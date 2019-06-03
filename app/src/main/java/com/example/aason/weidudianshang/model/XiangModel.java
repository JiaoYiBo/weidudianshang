package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.bean.XiangBean;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.XiangContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class XiangModel implements XiangContract.IXiangModel {

    @Override
    public void xiang(HashMap<String, String> map, final XiangModelCallBack xiangModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getxiang(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XiangBean>() {
                    @Override
                    public void accept(XiangBean xiangBean) throws Exception {
                        XiangBean.ResultBean result = xiangBean.getResult();
                        if (result != null) {
                            xiangModelCallBack.success(xiangBean);
                        } else {
                            xiangModelCallBack.fail(xiangBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface XiangModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
