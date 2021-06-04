package com.example.imagedemo.utils;

import android.os.Looper;
import android.util.Log;
import org.json.JSONObject;
import java.util.List;

public class CommUtils {
    private static final String TAG="CommUtils";

    public static void isMainThread() {
        Log.e(TAG, "---是否在主线程：" + (Thread.currentThread() == Looper.getMainLooper().getThread()));
    }

    /**
     * 判断list 是否为空
     * @param list
     * @param <T>
     * @return
     */
    public static  <T> boolean isListNotNull(List<T> list){
        if(list!=null&&!list.isEmpty()){
            return true;
        }
        return false;
    }
    /**
     * 判断list 是否为空
     * @param list
     * @param <T>
     * @return
     */
    public static  <T> boolean isListNull(List<T> list){
        if(list!=null&&!list.isEmpty()){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0 || s.equals("null");
    }

    public static boolean isNoEmpty(String s) {
        boolean bool=s == null || s.length() == 0 || s.equals("null");
        return !bool;
    }

    public static boolean  isJson(String json){
        try{
            JSONObject jsonObject = new JSONObject(json);
        }catch(Exception e){
            //Log.e(TAG,"该字符串不是json!\n"+json);
            return false;
        }
        return true;
    }




}
