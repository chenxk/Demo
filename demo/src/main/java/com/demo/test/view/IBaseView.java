package com.demo.test.view;


import com.demo.test.beans.ErrorInfo;

/**
 *
 * @author 100103010928
 * @date 2016/10/11
 */

public interface IBaseView<T> {

    void showProgress();

    void hideProgress();

    void requestSuccess(T response);

    void requestError(ErrorInfo e);
}
