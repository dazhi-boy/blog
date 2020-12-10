package com.dazhi.word.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dazhi.word.common.CoreCache;
import com.dazhi.word.core.entity.Word;
import com.dazhi.word.core.entity.WordTree;
import com.dazhi.word.core.mapper.WordMapper;
import com.dazhi.word.core.service.IWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhi.word.translate.DownloadUtils;
import com.dazhi.word.translate.GLOBAL;
import com.dazhi.word.translate.Main;
import com.dazhi.word.translate.TransApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 单词表 服务实现类
 * </p>
 *
 * @author dazhi
 * @since 2020-12-02
 */
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements IWordService {

    private static TransApi api = new TransApi(Main.APP_ID, Main.SECURITY_KEY);

    @Override
    public void init() throws IOException {
        // 1. 读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("world.txt").getFile()));
        // 2. 遍历
        String text;
        while ((text = bufferedReader.readLine()) != null) {
            // 3. 保存文件
//            System.out.println(text);
            Word word = new Word();
            word.setTerm(text);
            word.setGrade("primary");
            try {
                super.baseMapper.insert(word);
            }catch (Exception e){
                System.out.println(text + "重复");
            }
        }
        bufferedReader.close();
    }

    @Override
    public void initTranslate() {
        List<Word> words = super.baseMapper.selectList();
        for (Word word : words) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String query = word.getTerm();
            String res = api.getTransResult(query, "en", "zh");

            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(res).getAsJsonObject();
            JsonArray trans_result = jsonObject.get("trans_result").getAsJsonArray();
            JsonObject obj = (JsonObject) trans_result.get(0);
            String ch = obj.get("dst").getAsString();
            try {
                String temp = URLDecoder.decode(ch, "utf-8");
                System.out.println(temp);
                word.setTranslate(temp);
                super.baseMapper.updateById(word);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initMusic() {
        List<Word> words = super.baseMapper.selectList();
        GLOBAL.words = words;

        //get words url
        for (int i = 0; i < GLOBAL.words.size(); i++) {
            GLOBAL.wordsUrls.add(GLOBAL.baseAPI + GLOBAL.words.get(i).getTerm());
        }

        //download
        DownloadUtils downloadUtils = new DownloadUtils(this);
        try {
            downloadUtils.httpDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initTree() {
        //查询所有的单词
        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("grade","primary");
        List<Word> wordList = super.list(queryWrapper);
        Stack<Word> wordStack = new Stack<>();
        for (int i = (wordList.size()-1); i>=0; i--) {
            wordStack.push(wordList.get(i));
        }
        //将查询的数据重新组装
        WordTree wordTree = new WordTree();
        int count = (int) Math.ceil(wordList.size()/5);
        for (int i = 0; i<count; i++) {
            List<Word> words = new ArrayList<>();
            for (int j = 0; j<5; j++) {
                words.add(wordStack.pop());
            }
            wordTree.addWords(words);
        }
        CoreCache.WORD_TREE_CACHE.put(1L, wordTree);
        CoreCache.CURRENT_LEVEL.put(1L, 1);

        Queue<Word> wordQueue = new LinkedList<>();
        CoreCache.WORD_QUEUE.put(1L, wordQueue);
        try {
            while (true){
                Integer level = CoreCache.CURRENT_LEVEL.get(1L);
                WordTree wordTree1 = CoreCache.WORD_TREE_CACHE.get(1L);
                List<WordTree.Words> wordsList = wordTree1.getWordsList();
                List<WordTree.Words> newWordList =  wordsList.stream().filter(words -> words.getFrequency().equals(CoreCache.CURRENT_LEVEL.get(1L))).collect(Collectors.toList());
                if (newWordList.size() < Math.pow(2,level)) { // 如果还在当前层级
                    WordTree.Words word = wordsList.stream().filter(words -> words.getFrequency() == 0).collect(Collectors.toList()).get(0);
                    // 遍历，状态+1
                    word.setFrequency(word.getFrequency() + 1);
                    CoreCache.CURRENT_LEVEL.put(1L,1);
                    for(Word w : word.getWords()){
                        System.out.println(w);
                        wordQueue.offer(w);
                    }
                }else if (newWordList.size() == Math.pow(2,level)) {    // 如果正好相等，将符合条件的数据都组装起来发送，等级加一
                    //遍历装配数据，改状态+1
//                List<Word> list = new ArrayList<>();
                    for (WordTree.Words words : newWordList) {
                        words.setFrequency(words.getFrequency()+1);
//                    list.addAll(words.getWords());
                        for(Word w : words.getWords()){
                            System.out.println(w);
                            wordQueue.offer(w);
                        }
                    }
                    CoreCache.CURRENT_LEVEL.put(1L,level += 1);
                }
            }
        }catch (Exception e){
            System.out.println("初始化结束");
        }
    }

    @Override
    public Word getBatch() {
        Queue<Word> wordQueue = CoreCache.WORD_QUEUE.get(1L);
        return wordQueue.poll();
    }

    /*@Override
    public List<Word> getBatch() {
        Integer level = CoreCache.CURRENT_LEVEL.get(1L);
        WordTree wordTree = CoreCache.WORD_TREE_CACHE.get(1L);
        List<WordTree.Words> wordsList = wordTree.getWordsList();
        List<WordTree.Words> newWordList =  wordsList.stream().filter(words -> words.getFrequency().equals(CoreCache.CURRENT_LEVEL.get(1L))).collect(Collectors.toList());
        if (newWordList.size() < Math.pow(2,level)) { // 如果还在当前层级
            WordTree.Words word = wordsList.stream().filter(words -> words.getFrequency() == 0).collect(Collectors.toList()).get(0);
            // 遍历，状态+1
            word.setFrequency(word.getFrequency() + 1);
            CoreCache.CURRENT_LEVEL.put(1L,1);
            System.out.println("本次请求取得的数量：" + word.getWords().size());
            return word.getWords();
        }else if (newWordList.size() == Math.pow(2,level)) {    // 如果正好相等，将符合条件的数据都组装起来发送，等级加一
            //遍历装配数据，改状态+1
            List<Word> list = new ArrayList<>();
            for (WordTree.Words words : newWordList) {
                words.setFrequency(words.getFrequency()+1);
                list.addAll(words.getWords());
            }
            CoreCache.CURRENT_LEVEL.put(1L,level += 1);
            System.out.println("本次请求取得的数量：" + list.size());
            return list;
        }else {
            return null;
        }
    }*/
}
