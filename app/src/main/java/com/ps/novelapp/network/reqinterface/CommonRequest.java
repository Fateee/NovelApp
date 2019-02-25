package com.ps.novelapp.network.reqinterface;



import com.ps.novelapp.model.BannerBean;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.*;

public interface CommonRequest {
    //type = top; bottom; plugin
    @GET("api/banner")
    Observable<Response<BannerBean>> getBanner(@Query("type") String type);
}
