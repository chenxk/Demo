/*
 * Copyright 2017 Meorient, Inc. All rights reserved.
 */

package com.demo.test.util;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.demo.test.beans.BaseRequest;

import java.util.Arrays;
import java.util.Map;


/**
 * Description of SignHelper
 *
 * @author max.sun
 * @version $Id: SignHelper.java 1308 2017-02-08 10:18:48Z max.sun $
 * @created on 2017年2月8日
 */
public class SignHelper {
    private static Gson gson = MyApplication.getGson();

    public static String genSign(BaseRequest request) {
        Map<String, String> params = new ArrayMap<>();
        params.put("appVersion", request.getAppVersion());
        params.put("time", String.valueOf(request.getTime()));
        params.put("lang", request.getLang());
        params.put("token", request.getToken());
        params.put("data", getData(request.getData()));
        params.put("device", gson.toJson(request.getDevice()));
        // 第一步: 检查参数是否已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步: 把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();
        for (String key : keys) {
            String value = params.get(key);
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                query.append(key).append(value);
            }
        }

        // 第三步: 使用MD5/HMAC加密
        String signAll = EncryptHelper.md5(query.toString());
        return signAll.substring(signAll.length() - 4, signAll.length());
    }

    private static String getData(Object object) {
        if (object == null)
            return null;
        else if (object instanceof String)
            return (String) object;
        else
            return gson.toJson(object);

    }
}