package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.PageContract;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.model.PageModel;
import com.example.aason.weidudianshang.model.PinModel;

import java.util.HashMap;

public class PinPresenter extends PinContract.IPinPresenter {
    private final PinModel model;
    private PinContract.IPinView iPinView;

    public PinPresenter(PinContract.IPinView iPinView) {
        this.iPinView = iPinView;
        model = new PinModel();
    }

    @Override
    public void getpin(HashMap<String, String> map) {
        model.getpin(map, new PinModel.PinModelCallBack() {
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