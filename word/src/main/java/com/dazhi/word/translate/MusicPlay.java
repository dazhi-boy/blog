package com.dazhi.word.translate;

import com.dazhi.word.util.HttpUtil;

public class MusicPlay {
    public static void main(String[] args) {

        String res = HttpUtil.getHttp("https://danci.911cha.com/lesson_173.html");
        System.out.println(res);




        //get words url
        /*for (int i = 0; i < GLOBAL.words.size(); i++) {
            GLOBAL.wordsUrls.add(GLOBAL.baseAPI + GLOBAL.words.get(i).getTerm());
        }*/

        //download
        /*DownloadUtils downloadUtils = new DownloadUtils();
        try {
            downloadUtils.httpDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
