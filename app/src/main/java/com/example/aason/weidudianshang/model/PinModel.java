package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.PageBean;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.contract.PageContract;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PinModel implements PinContract.IPinModel {


    @Override
    public void getpin(HashMap<String, String> map, final PinModelCallBack pinModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getpin(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PinBean>() {
                    @Override
                    public void accept(PinBean pinBean) throws Exception {
                        List<PinBean.ResultBean> result = pinBean.getResult();
                        if (result != null) {
                            pinModelCallBack.success(pinBean);
                        } else {
                            pinModelCallBack.fail(pinBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface PinModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
