package com.dazhi.word.translate;

public class MusicPlay {
    public static void main(String[] args) {
        //get words url
        for (int i = 0; i < GLOBAL.words.size(); i++) {
            GLOBAL.wordsUrls.add(GLOBAL.baseAPI + GLOBAL.words.get(i).getTerm());
        }

        //download
        /*DownloadUtils downloadUtils = new DownloadUtils();
        try {
            downloadUtils.httpDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
