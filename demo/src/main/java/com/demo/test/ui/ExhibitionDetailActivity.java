package com.demo.test.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.demo.test.R;
import com.demo.test.beans.BaseResponse;
import com.demo.test.beans.ErrorInfo;
import com.demo.test.beans.ExhibitionDto;
import com.demo.test.presenter.ExhibitionPresenterImpl;
import com.demo.test.util.BaseRequestHelp;
import com.demo.test.view.ExhibitionDetailActivityView;
import com.demo.test.widget.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Administrator
 */
public class ExhibitionDetailActivity extends BaseActivity implements ExhibitionDetailActivityView {
    @BindView(R.id.tvText)
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition_detail);
        ButterKnife.bind(this);
        setTopTitle("展会详情");
        ExhibitionPresenterImpl exhibitionPresenter = new ExhibitionPresenterImpl(this);
        String id="100000091817";
        exhibitionPresenter.getExhibitionDetailInfo(this, BaseRequestHelp.create(id));
    }

    @Override
    public void showProgress() {
        LoadingDialog.show(this);
    }

    @Override
    public void hideProgress() {
        LoadingDialog.dismiss();
    }

    @Override
    public void requestSuccess(BaseResponse<ExhibitionDto> response) {
        if (response.getData() != null)
            tvText.setText(response.getData().toString());
    }

    @Override
    public void requestError(ErrorInfo e) {

    }
}
