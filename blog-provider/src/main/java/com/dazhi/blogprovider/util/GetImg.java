package com.dazhi.blogprovider.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Random;

@Component
public class GetImg {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始抓取数据");
        String term = "word";
        //创建一个文件夹
        String path = "D:\\word\\"+"primary"+"\\"+term;
        getImg(term, path);
        System.out.println("抓取数据完成");
    }

    public static void getImg(String term, String path) throws InterruptedException {
        String url = "https://cn.bing.com/images/async?q="+term+"&first=20&count=20&relp=20&tsc=ImageBasicHover&datsrc=I&layout=RowBased&mmasync=1&dgState=x*0_y*0_h*0_c*5_i*36_r*7";
        String html = HttpGet.get(url, null);
        System.out.println(html);
        //6.Jsoup解析html
        Document document = Jsoup.parse(html);
        //像js一样，通过标签获取title
//        System.out.println(document.getElementsByTag("img").first());
        //像js一样，通过id 获取文章列表元素对象
//        Element postList = document.getElementById("post_list");
        //像js一样，通过class 获取列表下的所有博客
        Elements postItems = document.getElementsByClass("mimg");
        //循环处理，循环10次
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (int i = 0; i<10;i++) {
            Thread.sleep(1000);
            Element postItem = postItems.get(i);
            //像jquery选择器一样，获取文章标题元素
//            Elements titleEle = postItem.select(".post_item_body a[class='titlelnk']");
//            System.out.println("文章标题:" + titleEle.text());;
//            System.out.println("文章地址:" + titleEle.attr("href"));
            //像jquery选择器一样，获取文章作者元素
//            Elements footEle = postItem.select(".post_item_foot a[class='lightblue']");
//            System.out.println("文章作者:" + footEle.text());;
//            System.out.println("图片地址:" + postItem.attr("src"));
            String imgUrl = postItem.attr("src");
            String _imgUrl = imgUrl.substring(0,imgUrl.indexOf("?"));
            System.out.println("图片地址:" + _imgUrl);
            //重新get请求下载图片
            HttpGet.getFile(_imgUrl,null,path + "\\" + i,"jpg");
        }
    }
}
