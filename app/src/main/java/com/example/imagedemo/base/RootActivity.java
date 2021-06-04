package com.example.imagedemo.base;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.imagedemo.utils.SystemConst;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.util.List;

import static com.example.imagedemo.utils.CommUtils.isListNull;

public class RootActivity extends RxAppCompatActivity {
    protected RxAppCompatActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }

    public <T> void showEmptyView(List<T> list, BaseMvvmRecyclerAdapter adapter, SmartRefreshLayout mRefresh, String content){
        if(isListNull(list)){
            if(mRefresh!=null){
                mRefresh.setEnableLoadMore(false);
                mRefresh.finishRefresh();
                mRefresh.finishLoadMore(true);
            }
            SystemConst.EMPTY_VIEW=true;
        }else{
            if(mRefresh!=null) {
                mRefresh.setEnableLoadMore(true);
                mRefresh.finishRefresh();
                mRefresh.finishLoadMore(true);
            }
            SystemConst.EMPTY_VIEW=false;
        }
        // ALog.v(adapter.getEmptyViewCount()+"---adapter.getEmptyViewCount()");
    }
}
