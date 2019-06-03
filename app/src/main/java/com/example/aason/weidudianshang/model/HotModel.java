package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HotModel implements HotContract.IhotModel {
    @Override
    public void hot(HashMap<String, String> map, final HotModel.HotModelCallBack hotModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getShow(ShowApi.Show_Api)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<ShowBean>() {
            @Override
            public void accept(ShowBean showBean) throws Exception {
                ShowBean.ResultBean result = showBean.getResult();
                if (result != null) {
                    hotModelCallBack.success(showBean);
                } else {
                    hotModelCallBack.fail(showBean);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.print(throwable);
            }
    });

    }
    public interface HotModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
