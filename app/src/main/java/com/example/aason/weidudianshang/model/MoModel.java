package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.HotBean;
import com.example.aason.weidudianshang.bean.MoBean;
import com.example.aason.weidudianshang.contract.MoContract;
import com.example.aason.weidudianshang.contract.ReContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MoModel implements MoContract.IMoModel {


    @Override
    public void getMo(HashMap<String, String> map, final MoModelCallBack moModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getmo(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MoBean>() {
                    @Override
                    public void accept(MoBean moBean) throws Exception {
                        List<MoBean.ResultBean> result = moBean.getResult();
                        if (result != null) {
                            moModelCallBack.success(moBean);
                        } else {
                            moModelCallBack.fail(moBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface MoModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
