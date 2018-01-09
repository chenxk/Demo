package com.demo.test.serviceapi;


import com.demo.test.beans.BaseRequest;
import com.demo.test.beans.BaseResponse;
import com.demo.test.beans.ExhibitionDto;
import com.demo.test.utildata.ConstantsData;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


/**
 * @author Administrator
 */
public interface HttpService {

    //

    /**
     * 获取展会详细信息
     */
    @POST("exhibition/getExhibitionDetailInfo.json")
    Observable<BaseResponse<ExhibitionDto>> getExhibitionDetailInfo(@Body BaseRequest request);
}
