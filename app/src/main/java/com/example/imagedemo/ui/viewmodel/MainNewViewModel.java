package com.example.imagedemo.ui.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.imagedemo.R;
import com.example.imagedemo.api.GlobalReq;
import com.example.imagedemo.base.BaseMvvmRecyclerAdapter;
import com.example.imagedemo.base.BaseViewModel;
import com.example.imagedemo.bean.ImageBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

import static com.example.imagedemo.utils.CommUtils.isListNotNull;

public class MainNewViewModel extends BaseViewModel {
    public MainNewViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    @Override
    public void onBundle(Bundle bundle) {

    }
    private ObservableArrayList<ImageBean.ListDTO> mList = new ObservableArrayList<>();
    public BaseMvvmRecyclerAdapter<ImageBean.ListDTO> mAdapter = new BaseMvvmRecyclerAdapter<ImageBean.ListDTO>(R.layout.item_image, mList) {
        @Override
        public void convert(BindingViewHolder holder, ImageBean.ListDTO item, int position) {

        }
    };

    public MutableLiveData<List<ImageBean.ListDTO>> getHomeList(int page, boolean isRefresh, String content) {
        if (isRefresh) {
            mPage.set(0);
        }
        final MutableLiveData<List<ImageBean.ListDTO>> data = new MutableLiveData<>();
        Disposable subscribe = GlobalReq.getInstance().getHomeList(mPage.get(), page,content)
                .subscribe(homeListBean -> {
                    List<ImageBean.ListDTO> ImageBeans = new ArrayList<>();
                    if (homeListBean != null) {
                        ImageBeans = homeListBean.getList();
                        if (isListNotNull(ImageBeans)) {
                            if (isRefresh) {
                                mList.clear();
                            }
                            mList.addAll(ImageBeans);
                        }
                    }

                    setPage(mList, isRefresh);
                    data.setValue(mList);
                });

        //没有用 CommonObserver 这里添加addDisposable
        addDisposable(subscribe);
        return data;
    }

    @BindingAdapter("loadImage")
    public static void setImage(ImageView imageView,String path){
        Glide.with(imageView.getContext())
                .load(TextUtils.isDigitsOnly(path) ? Integer.valueOf(path) : path)
                .apply(new RequestOptions().centerCrop())
                .into(imageView);
    }
}
