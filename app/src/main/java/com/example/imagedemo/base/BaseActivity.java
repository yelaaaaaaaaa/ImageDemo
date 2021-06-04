package com.example.imagedemo.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.imagedemo.BR;
import com.example.imagedemo.utils.ClassUtil;

import java.util.Map;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;



public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends RootActivity {
    public V mBinding;
    public VM mViewModel;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewDataBinding();
        //页面间传值
        if (savedInstanceState != null) {
            initBundle(savedInstanceState);
        } else if (getIntent() != null && getIntent().getExtras() != null) {
            initBundle(getIntent().getExtras());
        }
        initView();
    }

    /**
     * 绑定mViewModel
     */
    private void initViewDataBinding() {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        if(getLayoutId()==0){
            return;
        }
        mBinding =  DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = initMVVMViewModel();

        if (mViewModel == null) {
            createViewModel();
        }

        if (mViewModel != null) {
            mBinding.setVariable(initVariableId(), mViewModel);

            registorLiveDataCallBack();
            //页面事件监听的方法 用于ViewModel层转到View层的事件注册
            initViewObservable();
        }


    }

    private void initBundle(Bundle bundle) {
        if (mViewModel != null) {
            mViewModel.onBundle(bundle);
        }
    }

    /**
     * 初始化布局的id
     *
     * @return 布局的id
     */
    protected abstract int getLayoutId();

    /**
     * 不使用类名传来的ViewModel，使用临时自定义的ViewModel
     * @return 重写次方法返回
     */
    public VM initMVVMViewModel(){
        return null;
    }

    /**
     * 布局文件里的ViewModel默命名为viewModel（命名为其它请重写方法返回自定义的命名）
     */
    public int initVariableId() {
        return BR.viewModel;
    }


    public abstract void initViewObservable();
    /**
     * 初始化view
     */
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止空指针异常
        if (mViewModel != null) {
//            mViewModel.removeRxBus();
//            mViewModel.onDestroy();
            mViewModel = null;
        }
        if (mBinding != null) {
            mBinding.unbind();
        }
        unsubscribe();

    }


    /**
     * 添加activity里的订阅者 对订阅者统一管理,避免内存泄漏
     *
     * @param disposable
     */
    public void addRxDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * 解绑
     */
    public void unsubscribe() {
        if (this.mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            this.mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
    }

    /**
     * 创建ViewModel
     */
    private void createViewModel() {
        Class<VM> viewModelClass = ClassUtil.getViewModel(this);
        if (viewModelClass != null) {
            this.mViewModel = new ViewModelProvider(this).get(viewModelClass);
        }
    }




    /**
     * 注册(初始化)ViewModel与View的UI回调事件
     */
    protected void registorLiveDataCallBack() {
//        //加载对话框显示
//        mViewModel.getUILiveData().getShowDialogEvent().observe(this,s -> showDialog(s));
//        //加载对话框消失
//        mViewModel.getUILiveData().getDismissDialogEvent().observe(this,aVoid ->dismissDialog());
//        //跳入新页面
//        mViewModel.getUILiveData().getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
//            @Override
//            public void onChanged(@Nullable Map<String, Object> params) {
//                Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterType.CLASS);
//                Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterType.BUNDLE);
//                startActivity(clz, bundle);
//            }
//        });
//
//        //跳入新页面(共享元素动画)
//        mViewModel.getUILiveData().getStartActivityAnimationEvent().observe(this,stringObjectMap -> {
//            Class<?> clz = (Class<?>) stringObjectMap.get(BaseViewModel.ParameterType.CLASS);
//            Bundle bundle = (Bundle) stringObjectMap.get(BaseViewModel.ParameterType.BUNDLE);
//            View v= (View) stringObjectMap.get(BaseViewModel.ParameterType.VIEW);
//            String name= (String) stringObjectMap.get(BaseViewModel.ParameterType.VIEW_NAME);
//            startActivityAnimation(clz,v,name,bundle);
//        });
//
//        //finish界面
//        mViewModel.getUILiveData().getFinishEvent().observe(this,aVoid ->finish());
//        //关闭上一层
//        mViewModel.getUILiveData().getOnBackPressedEvent().observe(this, aVoid ->onBackPressed());
//
//        //跳转一个共用显示fragment页面
//        mViewModel.getUILiveData().getStartContainerActivityEvent().observe(this,params -> {
//            String canonicalName = (String) params.get(BaseViewModel.ParameterType.FARGMENT_NAME);
//            Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterType.BUNDLE);
//            startContainerActivity(canonicalName, bundle);
//        });
    }




}
