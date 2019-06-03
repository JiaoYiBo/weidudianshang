package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.contract.WanContract;
import com.example.aason.weidudianshang.model.PinModel;
import com.example.aason.weidudianshang.model.WanModel;

import java.util.HashMap;

public class WanPresenter extends WanContract.IWanPresenter {
    private final WanModel model;
    private WanContract.IWanView iWanView;

    public WanPresenter(WanContract.IWanView iWanView) {
        this.iWanView = iWanView;
        model = new WanModel();
    }

    @Override
    public void getwan(HashMap<String, String> map) {
        model.getwan(map, new WanModel.WanModelCallBack() {
            @Override
            public void success(Object result) {
                iWanView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iWanView.fail(msg);
            }
        });
    }
}