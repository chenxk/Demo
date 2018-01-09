package com.demo.test.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.demo.test.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * 欢迎界面
 * @author Administrator
 */
public class SplashActivity extends BaseActivity {
    @BindView(R.id.welcome)
    ImageView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}
