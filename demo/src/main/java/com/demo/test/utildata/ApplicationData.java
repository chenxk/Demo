package com.demo.test.utildata;


import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.demo.test.util.MyApplication;
import com.demo.test.util.SystemTool;

import java.util.Map;

import rx.Subscription;

/**
 * ApplicationData
 * @author Administrator
 */
public class ApplicationData {

    /**
     * 当前语言
     */
    public static String language = SystemTool.getSystemLanguage();
    /**
     * 移动设备型号
     */
    public static String deviceModel = SystemTool.getSystemModel();
    /**
     * 移动设备厂商
     */
    public static String deviceMake = SystemTool.getDeviceBrand();

    /**
     * 移动设备ID
     */
    public static String deviceId = SystemTool.getIMEI(MyApplication.getContext());

    /**
     * 系统版本号
     */
    public static String sysVersion = SystemTool.getSystemVersion();

    /**
     * subscription存放队列集合 方便取消注册
     */
    public static Map<Context, Subscription> subscriptionMap = new ArrayMap<>();

}
