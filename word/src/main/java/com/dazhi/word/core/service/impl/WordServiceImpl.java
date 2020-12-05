package com.dazhi.word.core.service.impl;

import com.dazhi.word.core.entity.Word;
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
import java.util.List;

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
}
