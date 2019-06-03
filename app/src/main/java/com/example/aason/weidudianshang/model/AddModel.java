package com.example.aason.weidudianshang.model;


import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.AddBean;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.contract.AddContract;
import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class AddModel implements AddContract.IAddModel{


    @Override
    public void adds(HashMap<String, String> map, HashMap<String, String> params, final AddModelCallBack addModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getAdd(map,params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AddBean>() {
                    @Override
                    public void accept(AddBean addBean) throws Exception {
                        if (addBean != null) {
                            addModelCallBack.success(addBean);
                        } else {
                            addModelCallBack.fail(addBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface AddModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
