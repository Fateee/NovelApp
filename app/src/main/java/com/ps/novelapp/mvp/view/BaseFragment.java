package com.ps.novelapp.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.novelapp.mvp.presenter.base.BasePresenter;
import com.ps.novelapp.mvp.presenter.base.BaseViewInf;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseViewInf {

//    private P mP;
    public static final int LATEST_TYPE = 1;
    public static final int CATEGORY_TYPE = 2;
    public static final int CHOSEN_TYPE = 3;
    private ProgressDialog loadingDialog;
    BasePresenter mPresenter;

    public P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
            if (mPresenter != null) mPresenter.attach(this);
        }
        return (P) mPresenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initData();
    }

    protected abstract P createPresenter();

    protected abstract int getContentView();

    protected abstract void initViews(View view);

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
        if (getPresenter() == null) return;
        getPresenter().deAttach();
    }
    public void showLoading() {
        loadingDialog = ProgressDialog.show(getContext(),"","");
    }

    public void dismissLoading() {
        loadingDialog.dismiss();
    }
}
