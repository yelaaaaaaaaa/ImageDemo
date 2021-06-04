package com.example.imagedemo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.imagedemo.R;
import com.example.imagedemo.base.BaseActivity;
import com.example.imagedemo.databinding.ActivityMainBinding;
import com.example.imagedemo.ui.viewmodel.MainNewViewModel;
import com.example.imagedemo.utils.GridItemDecoration;
import com.scwang.smart.refresh.header.ClassicsHeader;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainNewViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    protected void initView() {
        mBinding.mRecyclerView.addItemDecoration(new GridItemDecoration(10,false));
        mBinding.mRefreshLayout.setRefreshHeader(new ClassicsHeader(this));
        mBinding.mRefreshLayout.setOnRefreshListener(refreshLayout -> getHomeList(true));
        mBinding.mRefreshLayout.setOnLoadMoreListener(refreshLayout -> getHomeList(false));
        getHomeList(false);
        mBinding.tvClick.setOnClickListener(v -> {
            getHomeList(true);
        });
    }

    private void getHomeList(boolean isRefresh) {

        mViewModel.getHomeList(0, isRefresh,mBinding.etSearch.getEditableText().toString().trim()).observe(this, beans -> {
            showEmptyView(beans,mViewModel.mAdapter,mBinding.mRefreshLayout,"数据空空如也~");
                }

        );
    }
}