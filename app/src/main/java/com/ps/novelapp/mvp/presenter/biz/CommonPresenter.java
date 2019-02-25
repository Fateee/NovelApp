package com.ps.novelapp.mvp.presenter.biz;

import android.util.Log;


import com.ps.novelapp.model.BannerBean;
import com.ps.novelapp.mvp.presenter.base.BasePresenter;
import com.ps.novelapp.mvp.view.viewinf.CommonBaseIV;
import com.ps.novelapp.network.BaseRetrofit;
import com.ps.novelapp.network.reqinterface.CommonRequest;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CommonPresenter extends BasePresenter<CommonBaseIV> {

    private static final String TAG = "CommonPresenter";
    private final CommonRequest mCommonRequest;
    private int pageNo = 1;
    private int pageNum = 15;


    public CommonPresenter() {
        mCommonRequest = BaseRetrofit.getInstance().createRequest(CommonRequest.class);
    }

    public void getBanner(String type) {
        if (getView() == null) return;
        mCommonRequest.getBanner(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<BannerBean>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<BannerBean> value) {
                        if (value.code() == 200 && value.body() != null) {
                            ((CommonBaseIV.BannerIV) getView()).getBannerSuccess(value.body());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
