package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.bean.TongBean;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.contract.TongContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TongModel implements TongContract.ITongModel {


    @Override
    public void tong(HashMap<String, String> map, String tong, final TongModel.TongModelCallBack tongModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .gettong(map,tong)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TongBean>() {
                    @Override
                    public void accept(TongBean tongBean) throws Exception {
                        if (tongBean != null) {
                            tongModelCallBack.success(tongBean);
                        } else {
                            tongModelCallBack.fail(tongBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface TongModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
