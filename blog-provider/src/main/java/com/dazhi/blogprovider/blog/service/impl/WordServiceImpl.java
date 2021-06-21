package com.dazhi.blogprovider.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dazhi.blogprovider.blog.entity.Word;
import com.dazhi.blogprovider.blog.entity.WordTree;
import com.dazhi.blogprovider.blog.mapper.WordMapper;
import com.dazhi.blogprovider.blog.service.IWordService;
import com.dazhi.blogprovider.common.CoreCache;
import com.dazhi.blogprovider.common.GLOBAL;
import com.dazhi.blogprovider.util.DownloadUtils;
import com.dazhi.blogprovider.util.TransApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
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
    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    public static final String APP_ID = "20201204000636928";
    public static final String SECURITY_KEY = "yXSMl7jl5BDCU3SRWmFA";
    private static TransApi api = new TransApi(APP_ID, SECURITY_KEY);

    @Override
    public void init() throws IOException {
        // 1. 读取文件
        /*BufferedReader bufferedReader = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("world2.txt").getFile()));
        // 2. 遍历
        String text;
        while ((text = bufferedReader.readLine()) != null) {
            // 3. 保存文件primary | middle | high
//            System.out.println(text);
            Word word = new Word();
            word.setTerm(text);
            word.setGrade("middle");
            try {
                super.baseMapper.insert(word);
            }catch (Exception e){
                System.out.println(text + "重复");
            }
        }
        System.out.println("单词添加到数据库");senior1
        bufferedReader.close();*/
        List<String> list = new ArrayList<String>();
        Document document = Jsoup.connect("https://danci.911cha.com/lesson_206.html").get();
        Elements elements = document.getElementsByClass("l5");

        for (Element element : elements){
            Elements ets = element.getElementsByTag("a");
            for (Element et : ets){
                String text = et.html();
                list.add(text);
//                System.out.println(text);
               /* Word word = new Word();
                word.setTerm(text);
                word.setGrade("senior1");
                try {
                    super.baseMapper.insert(word);
                }catch (Exception e){
                    System.out.println(text + "重复");
                }*/
            }
        }
        list.sort(new StringComparator());
        for (String str : list) {
            Word word = new Word();
            word.setTerm(str);
            word.setGrade("college3");
            try {
                super.baseMapper.insert(word);
            }catch (Exception e){
                System.out.println(str + "重复");
            }
        }
        System.out.println("单词添加到数据库");
    }

    class StringComparator implements Comparator<String> {
        /**
         * 按字符串长度降序排序
         */
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();// 正确的方式
        }
    }

    @Override
    public void initTranslate() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("grade","college3");
        queryWrapper.isNull("translate");
        List<Word> words = super.baseMapper.selectList(queryWrapper);
        int i = 0;
        for (Word word : words) {
            try {
                Thread.sleep(1000);

                String query = word.getTerm();
                String res = api.getTransResult(query, "en", "zh");

                JsonParser parser = new JsonParser();
                JsonObject jsonObject = parser.parse(res).getAsJsonObject();
                JsonArray trans_result = jsonObject.get("trans_result").getAsJsonArray();
                JsonObject obj = (JsonObject) trans_result.get(0);
                String ch = obj.get("dst").getAsString();

                String temp = URLDecoder.decode(ch, "utf-8");
                System.out.println(temp);
                word.setTranslate(temp);
                super.baseMapper.updateById(word);
                System.out.println(++i);
            } catch (Exception e) {
                System.out.println("出错了："+word);
            }
        }
    }

    @Override
    public void initMusic() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("grade","college3");
//        queryWrapper.isNull("translate");
        List<Word> words = super.baseMapper.selectList(queryWrapper);
        GLOBAL.words = words;

        //get words url
        for (int i = 0; i < GLOBAL.words.size(); i++) {
            GLOBAL.wordsUrls.add(GLOBAL.baseAPI + GLOBAL.words.get(i).getTerm());
        }

        //download
        DownloadUtils downloadUtils = new DownloadUtils(this);
        try {
            downloadUtils.httpDownload();
            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initTree(String grade, Long userId) {
        //查询所有的单词
        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("grade",grade).eq("user_id",userId).isNull("status");
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
        CoreCache.WORD_TREE_CACHE.put(userId, wordTree);
        CoreCache.CURRENT_LEVEL.put(userId, 1);

        Queue<Word> wordQueue = new LinkedList<>();
        CoreCache.WORD_QUEUE.put(userId, wordQueue);
        try {
            while (true){
                Integer level = CoreCache.CURRENT_LEVEL.get(userId);
                WordTree wordTree1 = CoreCache.WORD_TREE_CACHE.get(userId);
                List<WordTree.Words> wordsList = wordTree1.getWordsList();
                List<WordTree.Words> newWordList =  wordsList.stream().filter(words -> words.getFrequency().equals(CoreCache.CURRENT_LEVEL.get(userId))).collect(Collectors.toList());
                if (newWordList.size() < Math.pow(2,level)) { // 如果还在当前层级
                    WordTree.Words word = wordsList.stream().filter(words -> words.getFrequency() == 0).collect(Collectors.toList()).get(0);
                    // 遍历，状态+1
                    word.setFrequency(word.getFrequency() + 1);
                    CoreCache.CURRENT_LEVEL.put(userId,1);
                    for(Word w : word.getWords()){
                        System.out.print(w.getTerm()+",");
                        wordQueue.offer(w);
                    }
                }else if (newWordList.size() == Math.pow(2,level)) {    // 如果正好相等，将符合条件的数据都组装起来发送，等级加一
                    //遍历装配数据，改状态+1
//                List<Word> list = new ArrayList<>();
                    for (WordTree.Words words : newWordList) {
                        words.setFrequency(words.getFrequency()+1);
//                    list.addAll(words.getWords());
                        for(Word w : words.getWords()){
                            System.out.print(w.getTerm()+",");
                            wordQueue.offer(w);
                        }
                    }
                    CoreCache.CURRENT_LEVEL.put(userId,level += 1);
                }
            }
        }catch (Exception e){
            System.out.println("初始化结束");
        }
    }

    @Override
    public void initWord(String grade, Long userId) {
        String sql = "INSERT INTo word (version,term,translate,`grade`,user_id) " +
                "(SELECT version,term,translate,`grade`,'"+userId+"' FROM word WHERE grade = '"+grade+"' and user_id is null)";
        WordMapper wordMapper = super.baseMapper;
        wordMapper.initWord(grade,userId);
    }

    @Override
    public Word getBatch(Long userId) {
        Queue<Word> wordQueue = CoreCache.WORD_QUEUE.get(userId);
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
