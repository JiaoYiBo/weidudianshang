package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.contract.ShouContract;
import com.example.aason.weidudianshang.model.DingModel;
import com.example.aason.weidudianshang.model.ShouModel;

import java.util.HashMap;

public class ShouPresenter extends ShouContract.IShouPresenter {
    private final ShouModel model;
    private ShouContract.IShouView iShouView;

    public ShouPresenter(ShouContract.IShouView iShouView) {
        this.iShouView = iShouView;
        model = new ShouModel();
    }

    @Override
    public void getshou(HashMap<String, String> map) {
        model.getshou(map, new ShouModel.ShouModelCallBack() {
            @Override
            public void success(Object result) {
                iShouView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iShouView.fail(msg);
            }
        });
    }
}
