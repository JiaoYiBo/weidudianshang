package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.bean.ShouBean;
import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.contract.ShouContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShouModel implements ShouContract.IShouModel {
    @Override
    public void getshou(HashMap<String, String> map, final ShouModelCallBack shouModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getshou(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ShouBean>() {
                    @Override
                    public void accept(ShouBean shouBean) throws Exception {
                        List<ShouBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = shouBean.getResult().getMlss().getCommodityList();
                        if (commodityList != null) {
                            shouModelCallBack.success(shouBean);
                        } else {
                            shouModelCallBack.fail(shouBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
    });
    }

    public interface ShouModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
