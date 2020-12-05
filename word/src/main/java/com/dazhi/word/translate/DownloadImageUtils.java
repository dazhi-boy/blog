package com.dazhi.word.translate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImageUtils {
    // 存放路径
    public static File rootDir = new File("D:\\mywordsImage");	// 存放文件路径

    // 接口来源
    public static String baseAPI=new String("https://cn.bing.com/images/search?q={key}&form=HDRSC2&first=1&tsc=ImageBasicHover");//t=1英音 t=0美英音 (建议t=1)

    public static int REPEAT = 1;							// 组合重复次数

    // 文件格式(勿动)
    public static String targetType = "html";// 目标文件的格式

    HttpURLConnection urlConnection;

    public void download() {
        try {


            urlConnection = (HttpURLConnection) new URL("https://cn.bing.com/images/async?q=apple&first=43&count=35&relp=35&tsc=ImageBasicHover&datsrc=I&layout=RowBased&mmasync=1").openConnection();
                            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();

            File temp = new File(rootDir, "word" + "." + targetType);// 分开
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
                System.out.println("word" + "下载成功");
            } else {
                System.out.println("word" + "重复");
            }
            //遍历单词，拼接路径
            //请求接口
            //将图片保存

        }catch (Exception e){
            System.out.println("出错了，可能有重复");
        }
    }

    public static void main(String[] args) {
        DownloadImageUtils downloadImageUtils = new DownloadImageUtils();
        downloadImageUtils.download();
    }
}
