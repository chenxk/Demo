package com.demo.test.presenter;

/**
 * Created by 100103010928 on 2016/10/12.
 */

public interface IBaseRequestCallBack<T> {

    void beforeRequest();

    void requestError(Throwable e);

    void requestComplete();

    void requestSuccess(T callBack);
}
