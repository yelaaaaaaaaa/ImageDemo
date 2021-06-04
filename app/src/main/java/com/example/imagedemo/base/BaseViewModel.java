package com.example.imagedemo.base;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;



import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import static com.example.imagedemo.utils.CommUtils.isListNotNull;


/**
 * BaseViewModel只使用 LiveData 方式去刷新数据
 *  也有其实的实现方式（但不太建议）
 *
 *  time 2019/11/27 10:07
 */
public abstract class BaseViewModel extends AndroidViewModel {
   // public int mPage = 1;//列表分页使用默认1开始
    public ObservableInt mPage= new ObservableInt(1);
    private CompositeDisposable mCompositeDisposable;
//    private UILiveData mUILiveData;

//    void initBundle(Bundle bundle) {
//        onCreate(bundle);
//    }

    public abstract void onBundle(Bundle bundle);

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    //避免Rxjava内存泄漏,
    //1、可以将Rxjava 订阅的时间添至CompositeDisposable进来，Activity销毁时切断订阅
    //2、也可以用 RxLifeCycle 将Rxjava绑定Acitivty/Fragment,销毁时自动取消订阅

    public void addDisposable(Disposable disposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {//此方法会在Activity/Fragment销毁时调用，可以在这里做一些额外释放资源的操作。
        super.onCleared();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.clear();
        }
    }


    public static final class ParameterType {
        public static String CLASS = "CLASS";
        public static String BUNDLE = "BUNDLE";
        public static String FARGMENT_NAME = "FARGMENT_NAME";
        //Activity跳转共享元素动画
        public static String VIEW = "VIEW";
        public static String VIEW_NAME = "VIEW_NAME";
    }


    /**
     * 请求成功后，设置下一次请求的分页
     * @param isRefresh 是否是下拉刷新
     */
    public void setPage(ObservableArrayList mList, boolean isRefresh){
        if(isListNotNull(mList)){
            if(isRefresh){
                //mPage=2;
                mPage.set(0);
            }else{
                mPage.set(mPage.get()+1);
               // mPage++;
            }
        }
       // ALog.i("下一次请求的分页数："+mPage.get());
    }
}
