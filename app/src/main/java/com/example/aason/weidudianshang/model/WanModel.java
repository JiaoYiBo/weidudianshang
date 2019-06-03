package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.bean.WanBean;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.contract.WanContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WanModel implements WanContract.IWanModel {


    @Override
    public void getwan(HashMap<String, String> map, final WanModelCallBack wanModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getwan(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<WanBean>() {
                    @Override
                    public void accept(WanBean wanBean) throws Exception {
                        List<WanBean.ResultBean> result = wanBean.getResult();
                        if (result != null) {
                            wanModelCallBack.success(wanBean);
                        } else {
                            wanModelCallBack.fail(wanBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface WanModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
