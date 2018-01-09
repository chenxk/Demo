package com.demo.test.presenter;

import android.content.Context;

import com.demo.test.beans.BaseRequest;
import com.demo.test.beans.BaseResponse;
import com.demo.test.beans.ExhibitionDto;
import com.demo.test.model.ExhibitionModelImpl;
import com.demo.test.view.ExhibitionDetailActivityView;


/**
 *
 * @author bob
 * @date 2016/11/7
 */

public class ExhibitionPresenterImpl extends BasePresenterImpl<ExhibitionDetailActivityView, BaseResponse<ExhibitionDto>> {
    private ExhibitionModelImpl exhibitionModel;

    public ExhibitionPresenterImpl(ExhibitionDetailActivityView view) {
        super(view);
        exhibitionModel = new ExhibitionModelImpl();
    }

    public void getExhibitionDetailInfo(Context context, BaseRequest request) {
        beforeRequest();
        exhibitionModel.getExhibitionDetailInfo(context, request, this);
    }
}
