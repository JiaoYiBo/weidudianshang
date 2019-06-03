package com.example.aason.weidudianshang.model;


import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class FootModel implements FootContract.IFootModel{


    @Override
    public void foot(HashMap<String, String> map, HashMap<String, String> params, final FootModelCallBack footModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getfoot(params,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FootBean>() {
                    @Override
                    public void accept(FootBean footBean) throws Exception {
                        List<FootBean.ResultBean> result = footBean.getResult();
                        if (result != null) {
                            footModelCallBack.success(footBean);
                        } else {
                            footModelCallBack.fail(footBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface FootModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
