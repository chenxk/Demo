package com.demo.test.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.demo.test.R;
import com.demo.test.util.MyActivityManager;

/**
 * @author bob.bop
 * @date 2015/11/12
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        MyActivityManager.getInstance().addActivity(this);
    }

    public void setTopTitle(String title) {
        TextView tvTitle = (TextView) findViewById(R.id.tvTopTitle);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    public void setTopTitle(int title) {
        TextView tvTitle = (TextView) findViewById(R.id.tvTopTitle);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    public void back(View v) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.getInstance().removeActivity(this);
    }
}
