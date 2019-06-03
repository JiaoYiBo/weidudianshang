package com.example.aason.weidudianshang.model;

import android.annotation.SuppressLint;

import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.bean.UserBean;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.UserContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserModel implements UserContract.IUserModel {
    private String value;
    private String key;

    @SuppressLint("CheckResult")
    @Override
    public void users(HashMap<String, String> map, final UserModelCallBack userModelCallBack) {
        for (Map.Entry<String,String>p:map.entrySet()){
            value = p.getValue();
            key = p.getKey();
        }
        //String s = ShowApi.USER_API + value + "";
        ResfateUtils.getmInstance().create(UserService.class)
                .getsou(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        List<UserBean.ResultBean> result = userBean.getResult();
                        if (result != null) {
                            userModelCallBack.success(userBean);
                        } else {
                            userModelCallBack.fail(userBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface UserModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
