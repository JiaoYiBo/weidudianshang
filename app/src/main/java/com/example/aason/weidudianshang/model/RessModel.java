package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.AddressBean;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.contract.AddressContract;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RessModel implements AddressContract.IRessModel {
    @Override
    public void ress(HashMap<String, String> map, final RessModelCallBack ressModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getaddress(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<AddressBean>() {
                    @Override
                    public void accept(AddressBean addressBean) throws Exception {
                        List<AddressBean.ResultBean> result = addressBean.getResult();
                        if (result != null) {
                            ressModelCallBack.success(addressBean);
                        } else {
                            ressModelCallBack.fail(addressBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface RessModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
