package com.demo.test.serviceapi;

import com.demo.test.presenter.IBaseRequestCallBack;

import rx.Subscriber;

/**
 * Created by 100103010928 on 2016/10/12.
 */

public class CustomSubscriber<T> extends Subscriber<T> {

    private IBaseRequestCallBack iBaseRequestCallBack;

    public CustomSubscriber(IBaseRequestCallBack iBaseRequestCallBack) {
        this.iBaseRequestCallBack = iBaseRequestCallBack;
    }

    @Override
    public void onCompleted() {
        iBaseRequestCallBack.requestComplete();
    }

    @Override
    public void onError(Throwable e) {
        iBaseRequestCallBack.requestError(e);
    }

    @Override
    public void onNext(T t) {
        iBaseRequestCallBack.requestSuccess(t);
    }
}
