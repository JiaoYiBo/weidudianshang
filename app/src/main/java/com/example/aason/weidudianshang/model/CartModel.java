package com.example.aason.weidudianshang.model;

import android.annotation.SuppressLint;

import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.CartBean;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CartModel implements CartContract.ICartModel {
    @Override
    public void cart(HashMap<String, String> map, final CartModelCallBack cartModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getcha(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChaBean>() {
                    @Override
                    public void accept(ChaBean chaBean) throws Exception {
                        List<ChaBean.ResultBean> result = chaBean.getResult();
                        if (result != null) {
                            cartModelCallBack.success(chaBean);
                        } else {
                            cartModelCallBack.fail(chaBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface CartModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
