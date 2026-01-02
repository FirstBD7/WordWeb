package com.sinosoft.wordweb.chat.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 翻译工具类（调用百度翻译API）
 */
@Slf4j
public class TranslateUtil {
    private static final String TRANS_API_HOST = "https://fanyi-api.baidu.com/api/trans/vip/translate";

    private String appid ;
    private String securityKey;

    public TranslateUtil(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }
    public TranslateUtil() {
        this.appid = "20260102002531688";
        this.securityKey = "8sqGpBN9fUBhFBwk0MG6";
    }

    public String getTransResult(String query) {
        String from = "en";
        String to = "zh";
        Map<String, String> params = buildParams(query, from, to);
        String jsonResult = HttpGet.get(TRANS_API_HOST, params);
        log.info("api返回结果：{}", jsonResult);
        // 1. 解析JSON字符串
        JSONObject resultObj = JSONObject.parseObject(jsonResult);
        // 2. 获取翻译结果（trans_result数组的第一个元素的dst字段）
        String unicodeDst = resultObj.getJSONArray("trans_result")
                .getJSONObject(0)
                .getString("dst");
        // 3. FastJSON会自动将Unicode转义（\u4f60\u597d）解码为中文
        return unicodeDst;
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

}
