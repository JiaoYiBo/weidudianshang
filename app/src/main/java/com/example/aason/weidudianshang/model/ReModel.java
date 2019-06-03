package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.HotBean;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.contract.ReContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ReModel implements ReContract.IReModel {


    @Override
    public void getRe(HashMap<String, String> map, final ReModelCallBack reModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .gethot(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<HotBean>() {
                    @Override
                    public void accept(HotBean hotBean) throws Exception {
                        List<HotBean.ResultBean> result = hotBean.getResult();
                        if (result != null) {
                            reModelCallBack.success(hotBean);
                        } else {
                            reModelCallBack.fail(hotBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface ReModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
