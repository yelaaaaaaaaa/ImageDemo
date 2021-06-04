package com.example.imagedemo.utils;


import android.content.Context;
import android.util.Log;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitFactory {
    public static final int TIMEOUT = 30;
    private static OkHttpClient okHttpClient;


    private static OkHttpClient getOkHttpClient() {

        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)//设置写入超时时间
                    //请求日志拦截打印
                    .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

                        @Override
                        public void log(String message) {
                            if (CommUtils.isJson(message)) {

                            } else {
                                Log.w("RetrofitFactory", message);
                            }

                        }
                    }).setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();

        }
        return okHttpClient;
    }

    public static Retrofit getInstance() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl("http://image.so.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        return mRetrofit;
    }




}
