package com.demo.test.model;

import android.content.Context;


import com.demo.test.beans.BaseRequest;
import com.demo.test.beans.BaseResponse;
import com.demo.test.beans.ExhibitionDto;
import com.demo.test.presenter.IBaseRequestCallBack;
import com.demo.test.serviceapi.CustomSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.demo.test.utildata.ApplicationData.subscriptionMap;

/**
 * Created by bob on 2016/11/7.
 */

public class ExhibitionModelImpl extends BaseModel {
    public void getExhibitionDetailInfo(Context context, BaseRequest request, IBaseRequestCallBack<BaseResponse<ExhibitionDto>> callBack) {
        subscriptionMap.put(context, httpService.getExhibitionDetailInfo(request)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomSubscriber<>(callBack)));
    }
}
