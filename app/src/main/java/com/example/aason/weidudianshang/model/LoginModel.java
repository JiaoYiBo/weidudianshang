package com.example.aason.weidudianshang.model;

import android.os.Handler;


import com.example.aason.weidudianshang.bean.LoginBean;
import com.example.aason.weidudianshang.contract.LoginContract;
import com.example.aason.weidudianshang.net.ResponseCallBcak;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements LoginContract.ILoginModel {
    Handler handler = new Handler();
    @Override
    public void setOkhttp(HashMap<String, String> map, String string, final ResponseCallBcak callBcak) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String>p:map.entrySet()){
         builder.add(p.getKey(),p.getValue());
        }
        Request request = new Request.Builder().url(string).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBcak.fail("网络连接超时");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                if (200 ==response.code()) {
                    getjson(result,callBcak);
                }
            }
        });
    }
    private void getjson(String result, final ResponseCallBcak callBcak) {
        final LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
        if (loginBean != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                callBcak.success(loginBean);
                }
            });
        }
    }
}
