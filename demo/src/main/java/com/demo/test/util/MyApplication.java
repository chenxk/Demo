package com.demo.test.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author bob.bop
 * @version $Id:java
 */
public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        context=this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getContext());
        super.onCreate();
    }


    public static Gson getGson() {
        return new GsonBuilder()
                .serializeNulls()
                .disableHtmlEscaping()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    public static Context getContext() {
        return context;
    }

}
