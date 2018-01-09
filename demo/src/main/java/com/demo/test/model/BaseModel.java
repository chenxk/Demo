package com.demo.test.model;


import com.demo.test.serviceapi.HttpService;
import com.demo.test.serviceapi.RetrofitManager;

/**
 *
 * @author 100103010928
 * @date 2016/10/12
 */

public class BaseModel {
    HttpService httpService;

    BaseModel() {
        //初始化retrofit
        RetrofitManager retrofitManager = RetrofitManager.getInstance();
        httpService = retrofitManager.getService();
    }

}
