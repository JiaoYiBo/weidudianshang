package com.example.aason.weidudianshang.model;


import com.example.aason.weidudianshang.api.ShowApi;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.contract.QuanContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class QuanModel  implements QuanContract.IQuanModel{
    @Override
    public void quan(HashMap<String, String> map, final QuanModelCallBack quanModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getquan( map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<QuanBean>() {
                    @Override
                    public void accept(QuanBean quanBean) throws Exception {
                        List<QuanBean.ResultBean> result = quanBean.getResult();
                        if (result != null) {
                            quanModelCallBack.success(quanBean);
                        } else {
                            quanModelCallBack.fail(quanBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
    });
    }
    public interface QuanModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
