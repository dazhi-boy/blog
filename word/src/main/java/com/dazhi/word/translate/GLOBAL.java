package com.dazhi.word.translate;

import com.dazhi.word.core.entity.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GLOBAL {
    /*-----------------------------------自定义begin-----------------------------------*/
    // 填写单词
    public static String sentence = new String(
            "furnish establish qualification apply terrific thrill allegiance freelance objection substantial interpret fraction denote fruitful inlet lame pinch remnant projector torrent incident zeal overlook shear propaganda prescribe cape");
    //public static String sentence = new String("apply furnish establish qualification apply terrific");
    public static List<Word> words = new ArrayList<>();		// 分隔符号

    // 存放路径
    public static File rootDir = new File("D:\\mywords");	// 存放文件路径

    // 接口来源
    public static String baseAPI=new String("http://dict.youdao.com/dictvoice?type=0&audio=");//t=1英音 t=0美英音 (建议t=1)

    // 组合
    public static boolean BIND = false;						// 是否组合
    public static String BINDNAME = "wordlist1";			// 组合文件名
    public static int REPEAT = 1;							// 组合重复次数

    /*-----------------------------------自定义end-----------------------------------*/

    // 文件格式(勿动)
    public static String targetType = "mp3";// 目标文件的格式

    // 完整音频url(勿动)
    public static List<String> wordsUrls = new ArrayList<>();// 目标链接字符串
}
