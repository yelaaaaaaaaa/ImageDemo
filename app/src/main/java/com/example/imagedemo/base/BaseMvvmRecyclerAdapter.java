package com.example.imagedemo.base;

import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.imagedemo.BR;
import com.example.imagedemo.utils.SystemConst;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class BaseMvvmRecyclerAdapter<T> extends BaseQuickAdapter<T, BaseMvvmRecyclerAdapter.BindingViewHolder> implements LoadMoreModule {
    private ObservableList<T> mTObservableList;//让list数据变更后自动notifyItemRangeChanged刷新
    public RecyclerView recyclerView;

    //在RecyclerView提供数据的时候调用
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }


    protected BaseMvvmRecyclerAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
        this.mTObservableList = data == null ? new ObservableArrayList<T>() : (ObservableList<T>) data;
//        if (layoutResId != 0) {
//            this.mLayoutResId = layoutResId;
//        }
        mTObservableList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<T>>() {
            @Override
            public void onChanged(ObservableList<T> ts) {
                 notifyDataSetChanged();

            }
            @Override
            public void onItemRangeChanged(ObservableList<T> ts, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);

            }

            @Override
            public void onItemRangeInserted(ObservableList<T> ts, int positionStart, int itemCount) {
                if(SystemConst.EMPTY_VIEW){
                    setNewInstance(ts);
                }else{
                    notifyItemRangeInserted(positionStart, itemCount);
                }

            }

            @Override
            public void onItemRangeMoved(ObservableList<T> ts, int fromPosition, int toPosition, int itemCount) {
                for (int i = 0; i < itemCount; i++) {
                    notifyItemMoved(fromPosition + i, toPosition + i);
                }

            }
            @Override
            public void onItemRangeRemoved(ObservableList<T> ts, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);

            }
        });
    }

    //    @Override
//    public BaseMvvmRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        super.onCreateViewHolder(parent,viewType);
//        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutResId, parent, false);
//        return BaseMvvmRecyclerHolder.getRecyclerHolder(binding,binding.getRoot());
//    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BindingViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

//    @Override
//    protected View getItemView(int layoutResId, ViewGroup parent) {
//        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
//        if (binding == null) {
//            return super.getItemView(layoutResId, parent);
//        }
//        View view = binding.getRoot();
//        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
//        return view;
//    }

    @Override
    protected void convert(@NonNull BindingViewHolder helper, T item) {
        ViewDataBinding binding = DataBindingUtil.getBinding(helper.itemView);
        // 建议item.xml里的bean的别名都取itemBean，自定义命名的话，构造函数又要增加一个别名参数（variableId）
        binding.setVariable(BR.itemBean, item);
        binding.executePendingBindings();

        //BaseQuickAdapter position获取
        int position = helper.getAdapterPosition();
        if (position == RecyclerView.NO_POSITION) {
            return;
        }
        position -= this.getHeaderLayoutCount();

        convert(helper,item,position);
    }

    /**
     * 填充RecyclerView适配器的方法
     */
    public abstract void convert(BindingViewHolder holder, T item, int position);

    public static class BindingViewHolder extends BaseViewHolder {
        public BindingViewHolder(View view) {
            super(view);
        }
//        public ViewDataBinding getBinding() {
//            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
//        }
    }

}
