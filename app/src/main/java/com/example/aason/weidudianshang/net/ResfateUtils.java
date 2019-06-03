package com.example.aason.weidudianshang.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResfateUtils {
    private final Retrofit retrofit;
    private static ResfateUtils mInstance;
    //单例模式
    public static  ResfateUtils getmInstance(){
        if (mInstance == null) {
            synchronized (ResfateUtils.class){
                if (mInstance == null) {
                    mInstance = new ResfateUtils();
                }
            }
        }
        return mInstance;
    }
    // 日志拦截器
    public ResfateUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addInterceptor(new QinqiuUtils())
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }



    public <T> T create(Class<T> tClass){
        return  retrofit.create(tClass);
    }
}
