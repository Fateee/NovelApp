package com.ps.novelapp.network;

import android.util.Log;

import com.ps.novelapp.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofit {

    private OkHttpClient client;
    private volatile static BaseRetrofit mBaseRetrofit;
    private Retrofit retrofit;
    private String baseUrl;

    private BaseRetrofit() {
        baseUrl = Urls.mBaseUrl;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.i("RetrofitLog", "retrofitBack = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS)
                .build();
    }

    public static BaseRetrofit getInstance() {
        if (mBaseRetrofit == null) {
            synchronized (BaseRetrofit.class) {
                if (mBaseRetrofit == null) {
                    mBaseRetrofit = new BaseRetrofit();
                }
            }
        }
        return mBaseRetrofit;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(FastJsonConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public <T> T initRetrofit(Class<T> service) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Urls.mBaseUrl).addConverterFactory(GsonConverterFactory.create());
        if (Urls.debug && client != null) {
            builder.client(client);
        }
        Retrofit mRetrofit = builder.build();
        return mRetrofit.create(service);
    }

    public <T> T initRetrofit(String url, Class<T> service) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        if (Urls.debug && client != null) {
            builder.client(client);
        }
        Retrofit mRetrofit = builder.build();
        return mRetrofit.create(service);
    }

    public <T> T createRequest(final Class<T> service) {
        return getRetrofit().create(service);
    }
}
