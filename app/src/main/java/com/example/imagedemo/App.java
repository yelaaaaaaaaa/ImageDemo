package com.example.imagedemo;

import android.app.Application;
import android.util.Log;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setRxJavaErrorHandler();
    }
    /**
     * RxJava3 当取消订阅后(dispose())，RxJava 抛出的异常后续无法接收,全部由 RxJavaPlugin 接收，需要提前设置 ErrorHandler.
     */
    private void setRxJavaErrorHandler() {
        RxJavaPlugins.setErrorHandler(throwable -> {
            throwable.printStackTrace();
            Log.e("MyApplication", "MyApplication setRxJavaErrorHandler " + throwable.getMessage());
        });
    }
}
