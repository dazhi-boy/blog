package com.dazhi.word.translate;

import com.dazhi.word.core.service.IWordService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUtils {
    private IWordService iWordService = null;

    public DownloadUtils(IWordService iWordService) {
        this.iWordService = iWordService;
    }

    // 开始下载
    public void httpDownload() throws Exception {
        validate();// check
        HttpURLConnection urlConnection;

        for (int i = 0; i < GLOBAL.wordsUrls.size(); i++) {
            Thread.sleep(1500);
            int r = GLOBAL.REPEAT;
            while (r > 0) {
                try {
                    r--;

                    String word = (String) GLOBAL.wordsUrls.get(i).subSequence(GLOBAL.wordsUrls.get(i).lastIndexOf("=") + 1,
                            GLOBAL.wordsUrls.get(i).length());
                    urlConnection = (HttpURLConnection) new URL(GLOBAL.wordsUrls.get(i)).openConnection();
                    urlConnection.connect();
                    InputStream inputStream = urlConnection.getInputStream();

                    if (GLOBAL.BIND) {// bind
                        File temp = new File(GLOBAL.rootDir, GLOBAL.BINDNAME + "." + GLOBAL.targetType);// 合一起
                        if (!temp.exists()) {
                            temp.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(temp, true);
                        int t;
                        while (-1 != (t = inputStream.read())) {
                            fileOutputStream.write(t);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                        inputStream.close();
                        System.out.println(word + "下载成功");
                    } else {// not bind
                        File temp = new File(GLOBAL.rootDir, word + "." + GLOBAL.targetType);// 分开
                        if (!temp.exists()) {
                            temp.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(temp, true);
                            int tem;
                            while (-1 != (tem = inputStream.read())) {
                                fileOutputStream.write(tem);
                                fileOutputStream.flush();
                            }
                            fileOutputStream.close();
                            inputStream.close();
                            System.out.println(word + "下载成功");
                        } else {
                            System.out.println(word + "重复");
                        }
                    }



                }catch (Exception e){
                    iWordService.removeById(GLOBAL.words.get(i).getId());
                    System.out.println("出错了，可能有重复");
                }
            }
        }
    }

    private void validate() throws Exception {
        if (GLOBAL.wordsUrls.size() <= 0) {
            throw new Exception("下载路径不能为空!");
        }
        if (null == GLOBAL.rootDir || !GLOBAL.rootDir.exists() || !GLOBAL.rootDir.isDirectory()) {
            throw new Exception("目标文件夹不存在!");
        }
    }
}
