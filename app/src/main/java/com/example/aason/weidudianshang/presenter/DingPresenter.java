package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.model.DingModel;

import java.util.HashMap;

public class DingPresenter extends DingContract.IDingPresenter {
    private final DingModel model;
    private DingContract.IDingView iDingView;

    public DingPresenter(DingContract.IDingView iDingView) {
        this.iDingView = iDingView;
        model = new DingModel();
    }

    @Override
    public void getding(HashMap<String, String> map) {
        model.getding(map, new DingModel.DingModelCallBack() {
            @Override
            public void success(Object result) {
                iDingView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iDingView.fail(msg);
            }
        });
    }
}
