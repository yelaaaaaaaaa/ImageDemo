package com.example.imagedemo.api;


import com.example.imagedemo.bean.ImageBean;

import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface GlobalApi {
    @GET("/j")
    Observable<ImageBean> getHomeList(@Query("sn") int page,@Query("q") String searchContent,@Query("pn") int size);


}
