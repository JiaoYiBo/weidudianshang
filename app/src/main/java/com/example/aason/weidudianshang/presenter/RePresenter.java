package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.ReContract;
import com.example.aason.weidudianshang.model.HotModel;
import com.example.aason.weidudianshang.model.ReModel;

import java.util.HashMap;

public class RePresenter extends ReContract.IRePresneter {
    private final ReModel model;
    private ReContract.IReView iReView;

    public RePresenter(ReContract.IReView iReView) {
        this.iReView = iReView;
        model = new ReModel();
    }

    @Override
    public void getRe(HashMap<String, String> map) {
        model.getRe(map, new ReModel.ReModelCallBack() {
            @Override
            public void success(Object result) {
                iReView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iReView.fail(msg);
            }
        });
    }
}
