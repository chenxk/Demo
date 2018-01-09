package com.demo.test.serviceapi;

import com.demo.test.util.JsonFormat;
import com.demo.test.util.LogUtil;
import com.demo.test.util.MyApplication;
import com.demo.test.utildata.ApplicationData;
import com.demo.test.utildata.ConstantsData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author 100103010928
 * @date 2016/10/12
 */

public class RetrofitManager {

    private static OkHttpClient mOkHttpClient;
    private static HttpService httpService;

    private RetrofitManager() {
        initRetrofit();
    }

    public static void initRetrofit() {
        initOkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
//                .client(builder.build())
                .client(mOkHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(MyApplication.getGson()))
//                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ConstantsData.BASE_URL)
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public HttpService getService() {
        return httpService;
    }

    private static void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {
                    // 指定缓存路径,缓存大小100Mb
//                    Cache cache = new Cache(new File(MyApplication.getContext().getCacheDir(), "HttpCache"),
//                            1024 * 1024 * 100);
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor((message) ->
                            LogUtil.i("result", JsonFormat.format(message)));
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    mOkHttpClient = new OkHttpClient.Builder()
//                            .cache(cache)
//                            .addInterceptor(mRewriteCacheControlInterceptor)
//                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .hostnameVerifier((hostname, session) -> false)
                            .addInterceptor(chain -> {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Connection", "close").build();
                                return chain.proceed(request);
                            })
//                            .addNetworkInterceptor(new StethoInterceptor())
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .readTimeout(15, TimeUnit.SECONDS)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return RetrofitManager.SingletonHolder.INSTANCE;
    }

}
