package com.example.aason.weidudianshang.presenter;

import android.content.Context;

import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.model.HotModel;

import java.util.HashMap;

public class HotPresenter extends HotContract.IhotPresenter {
    private final HotModel model;
    private HotContract.IhotView ihotView;

    public HotPresenter(HotContract.IhotView ihotView) {
        this.ihotView = ihotView;
        model = new HotModel();
    }

    @Override
    public void hot(HashMap<String, String> map) {
        model.hot(map, new HotModel.HotModelCallBack() {
            @Override
            public void success(Object result) {
                ihotView.success(result);
            }

            @Override
            public void fail(Object msg) {
                ihotView.fail(msg);
            }
        });
    }
}
