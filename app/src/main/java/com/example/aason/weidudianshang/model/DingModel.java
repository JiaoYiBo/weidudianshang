package com.example.aason.weidudianshang.model;

import android.app.Service;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DingModel implements DingContract.IDingModel {
    @Override
    public void getding(HashMap<String, String> map, final DingModelCallBack dingModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getding(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<DingBean>() {
                    @Override
                    public void accept(DingBean dingBean) throws Exception {
                        List<DingBean.ResultBean.RxxpBean.CommodityListBean> commodityList = dingBean.getResult().getRxxp().getCommodityList();
                        if (commodityList != null) {
                            dingModelCallBack.success(dingBean);
                        } else {
                            dingModelCallBack.fail(dingBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
    });
    }

    public interface DingModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
