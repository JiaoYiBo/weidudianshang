package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.PinsContract;
import com.example.aason.weidudianshang.model.HotModel;
import com.example.aason.weidudianshang.model.PinsModel;

import java.util.HashMap;

public class PinsPresenter extends PinsContract.IPinPresenter {
    private final PinsModel model;
    private PinsContract.IPinView iPinView;

    public PinsPresenter(PinsContract.IPinView iPinView) {
        this.iPinView = iPinView;
        model = new PinsModel();
    }

    @Override
    public void getpins(HashMap<String, String> map) {
        model.getpins(map, new PinsModel.PinsModelCallBack() {
            @Override
            public void success(Object result) {
                iPinView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iPinView.fail(msg);
            }
        });
    }
}
