/*
 * Copyright 2017 Meorient, Inc. All rights reserved.
 */

package com.demo.test.beans;

/**
 * Description of BaseProtocol
 *
 * @author max.sun
 * @version $Id: BaseProtocol.java 1344 2017-02-10 01:26:35Z max.sun $
 * @created on 2017年2月3日
 */
public abstract class BaseProtocol extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 时间戳 yyyyMMddHHmmssS
     */
    private long time;

    /**
     * MD5签名
     */
    private String sign;

    public BaseProtocol() {
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
