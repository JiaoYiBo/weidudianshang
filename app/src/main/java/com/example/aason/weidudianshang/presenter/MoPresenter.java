package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.MoContract;
import com.example.aason.weidudianshang.contract.ReContract;
import com.example.aason.weidudianshang.model.MoModel;
import com.example.aason.weidudianshang.model.ReModel;

import java.util.HashMap;

public class MoPresenter extends MoContract.IMoPresneter {
    private final MoModel model;
    private MoContract.IMoView iMoView;

    public MoPresenter(MoContract.IMoView iMoView) {
        this.iMoView = iMoView;
        model = new MoModel();
    }

    @Override
    public void getMo(HashMap<String, String> map) {
        model.getMo(map, new MoModel.MoModelCallBack() {
            @Override
            public void success(Object result) {
                iMoView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iMoView.fail(msg);
            }
        });
    }
}
