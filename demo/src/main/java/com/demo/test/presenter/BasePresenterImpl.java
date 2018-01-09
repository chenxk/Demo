package com.demo.test.presenter;

import android.util.Log;
import android.widget.Toast;

import com.demo.test.beans.BaseResponse;
import com.demo.test.beans.ErrorInfo;
import com.demo.test.util.LogUtil;
import com.demo.test.util.MyApplication;
import com.demo.test.view.IBaseView;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 *
 * @author 100103010928
 * @date 2016/10/12
 */

public class BasePresenterImpl<T extends IBaseView, V> implements IBasePresenter, IBaseRequestCallBack<V> {
    private IBaseView iView;

    public BasePresenterImpl(T view) {
        this.iView = view;
    }

    @Override
    public void beforeRequest() {
        iView.showProgress();
    }

    @Override
    public void requestError(Throwable e) {
        iView.hideProgress();
        ErrorInfo errorInfo = new ErrorInfo();
        if (e instanceof SocketTimeoutException) {
            errorInfo.setCode(1000);
            errorInfo.setMessage("Timeout");
        } else if (e instanceof ConnectException) {
            errorInfo.setCode(1001);
            errorInfo.setMessage("ConnectException");
        } else if (e instanceof HttpException) {
            int code = ((HttpException) e).code();
            errorInfo.setCode(code);
            errorInfo.setMessage(e.getMessage());
        } else if (e instanceof JSONException || e instanceof JsonSyntaxException) {
            errorInfo.setCode(401);
            errorInfo.setMessage("JSONException");
        } else {
            errorInfo.setCode(1002);
            errorInfo.setMessage(e.getMessage());
        }
        iView.requestError(errorInfo);
        LogUtil.e("Exception", "Exception:" + Log.getStackTraceString(e));
        Toast.makeText(MyApplication.getContext(), errorInfo.getMessage(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestComplete() {
        iView.hideProgress();
    }

    @Override
    public void requestSuccess(V callBack) {
        if (callBack instanceof BaseResponse) {
            ErrorInfo errorInfo;
            BaseResponse response = (BaseResponse) callBack;
            switch (response.getCode()) {
                case "0":
                    iView.requestSuccess(response);
                    break;
                case "100001":
                    break;
                default:
                    Toast.makeText(MyApplication.getContext(), response.getMessage(),
                            Toast.LENGTH_SHORT).show();
                    errorInfo = new ErrorInfo();
                    errorInfo.setCode(Integer.valueOf(response.getCode()));
                    errorInfo.setMessage(response.getMessage());
                    iView.requestError(errorInfo);
                    break;
            }
        } else {
            JSONObject response = null;
            try {
                response = new JSONObject((String) callBack);
                int code = response.optInt("Code");
                String message = response.optString("Message");
                iView.requestSuccess(callBack);
            } catch (JSONException e) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setCode(10000);
                errorInfo.setMessage("JsonException");
                iView.requestError(errorInfo);
                e.printStackTrace();
                LogUtil.e("Exception", "Exception:" + Log.getStackTraceString(e));
            }
        }
        iView.hideProgress();
    }


    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
