package com.example.imagedemo.api;




import android.text.TextUtils;

import com.example.imagedemo.bean.ImageBean;
import com.example.imagedemo.utils.RetrofitFactory;

import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class GlobalReq {

    private static volatile GlobalReq mInstance;

    public static GlobalReq getInstance() {
        if (mInstance == null) {
            synchronized (GlobalReq.class) {
                if (mInstance == null) {
                    mInstance = new GlobalReq();
                }
            }
        }
        return mInstance;
    }

    /**
     * 返回 Observable<ResultBean<T>> 类型
     */
    private <T> Observable<T> requests(Observable<T> beanObservable) {
        return beanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ImageBean> getHomeList(int page, int cid, String content) {
        return requests(RetrofitFactory.getInstance().create(GlobalApi.class).getHomeList(page, TextUtils.isEmpty(content)?"北京":content,30));
    }

}
