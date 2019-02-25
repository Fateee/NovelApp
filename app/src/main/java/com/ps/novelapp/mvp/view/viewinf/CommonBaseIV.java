package com.ps.novelapp.mvp.view.viewinf;


import com.ps.novelapp.mvp.presenter.base.BaseViewInf;

public interface CommonBaseIV extends BaseViewInf {
    void showLoading();
    void dismissLoading();

    interface BannerIV extends CommonBaseIV {
        void getBannerSuccess(Object data);
    }
}
