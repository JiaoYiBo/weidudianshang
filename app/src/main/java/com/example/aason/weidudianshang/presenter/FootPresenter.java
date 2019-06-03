package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.model.FootModel;
import com.example.aason.weidudianshang.model.HotModel;

import java.util.HashMap;

public class FootPresenter extends FootContract.IFootPresenter {
    private final FootModel model;
    private FootContract.IFootView iFootView;

    public FootPresenter(FootContract.IFootView iFootView) {
        this.iFootView = iFootView;
        model = new FootModel();
    }

    @Override
    public void foot(HashMap<String, String> map, HashMap<String, String> params) {
        model.foot(map, params, new FootModel.FootModelCallBack() {
            @Override
            public void success(Object result) {
                iFootView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iFootView.fail(msg);
            }
        });
    }
}
