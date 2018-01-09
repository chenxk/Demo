package com.demo.test.util;

import android.support.annotation.Nullable;

import com.demo.test.beans.BaseRequest;
import com.demo.test.utildata.ApplicationData;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/10.
 */

public class BaseRequestHelp {
    public static BaseRequest create(@Nullable Object data) {
        BaseRequest request = new BaseRequest();
        request.setData(data);
        request.setToken("");
        request.setTime(System.currentTimeMillis());
        request.setSign(SignHelper.genSign(request));
        return request;
    }
}
