package com.example.aason.weidudianshang.model;


import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.bean.XiuBean;
import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.contract.NameContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class NameModel implements NameContract.INameModel{


    @Override
    public void names(HashMap<String, String> map, HashMap<String, String> param, final INameModelCallBack iNameModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getName(map,param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XiuBean>() {
                    @Override
                    public void accept(XiuBean xiuBean) throws Exception {
                        if (xiuBean != null) {
                            iNameModelCallBack.success(xiuBean);
                        } else {
                            iNameModelCallBack.fail(xiuBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface INameModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
