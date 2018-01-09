/*
 * Copyright 2017 Meorient, Inc. All rights reserved.
 */

package com.demo.test.beans;

import com.demo.test.util.MyApplication;
import com.demo.test.util.SystemTool;
import com.demo.test.utildata.ApplicationData;

/**
 * Description of BaseRequest
 *
 * @author max.sun
 * @version $Id: BaseRequest.java 1344 2017-02-10 01:26:35Z max.sun $
 * @created on 2017年2月3日
 */
public class BaseRequest extends BaseProtocol {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 设备信息
     */
    private DeviceDto device = new DeviceDto();

    /**
     * APP版本
     */
    private String appVersion = String.valueOf(SystemTool.getAppVersionCode(MyApplication.getContext()));

    /**
     * 登录凭证
     */
    private String token = "";

    /**
     * 当前语言
     */
    private String lang = ApplicationData.language;

    /**
     * 实体数据
     */
    private Object data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public DeviceDto getDevice() {
        return device;
    }

    public void setDevice(DeviceDto device) {
        this.device = device;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
