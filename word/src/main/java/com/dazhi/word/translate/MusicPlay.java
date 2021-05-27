package com.dazhi.word.translate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MusicPlay {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://danci.911cha.com/lesson_173.html").get();
        Elements elements = document.getElementsByClass("l5");

        for (Element element : elements){
            Elements ets = element.getElementsByTag("a");
            System.out.println(ets.html());
        }



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
