package com.dazhi.word.translate;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    public static final String APP_ID = "20201204000636928";
    public static final String SECURITY_KEY = "yXSMl7jl5BDCU3SRWmFA";

    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "height";
        String res = api.getTransResult(query, "en", "zh");

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(res).getAsJsonObject();
        JsonArray trans_result = jsonObject.get("trans_result").getAsJsonArray();
        JsonObject obj = (JsonObject) trans_result.get(0);
        String ch = obj.get("dst").getAsString();
        System.out.println(URLDecoder.decode(ch, "utf-8") );

//        String str = "http://dict.youdao.com/dictvoice?type=0&audio=hello";
    }

}
