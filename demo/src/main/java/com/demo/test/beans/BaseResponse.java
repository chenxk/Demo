package com.demo.test.beans;

/**
 * Created by Administrator on 2017/1/17.
 */

public class BaseResponse<T> extends BaseProtocol {
    /**
     * 返回代码
     */
    private String code;

    /**
     * 返回详细信息
     */
    private String message;

    /**
     * 登录授权的token
     */
    private String token;

    /**
     * 站点
     */
    private String websiteId;

    /**
     * 返回数据值 具体参考对应实现的实体
     **/
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
    }
}
