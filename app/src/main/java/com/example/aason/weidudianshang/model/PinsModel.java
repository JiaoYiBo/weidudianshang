package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.PinZhiBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.contract.PinsContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PinsModel implements PinsContract.IPinModel {
    @Override
    public void getpins (HashMap<String, String> map, final PinsModel.PinsModelCallBack pinsModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getPIN(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PinZhiBean>() {
                    @Override
                    public void accept(PinZhiBean pinZhiBean) throws Exception {
                        List<PinZhiBean.ResultBean> result = pinZhiBean.getResult();
                        if (result != null) {
                            pinsModelCallBack.success(pinZhiBean);
                        } else {
                            pinsModelCallBack.fail(pinZhiBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface PinsModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
