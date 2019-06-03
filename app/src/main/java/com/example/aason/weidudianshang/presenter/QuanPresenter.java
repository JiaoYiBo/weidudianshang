package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.QuanContract;
import com.example.aason.weidudianshang.model.QuanModel;

import java.util.HashMap;

public class QuanPresenter extends QuanContract.IQuanPresenter {
    private final QuanModel model;
    private QuanContract.IQuanView iQuanView;

    public QuanPresenter(QuanContract.IQuanView iQuanView) {
        this.iQuanView = iQuanView;
        model = new QuanModel();
    }

    @Override
    public void quan(HashMap<String, String> map) {
        model.quan(map, new QuanModel.QuanModelCallBack() {
            @Override
            public void success(Object result) {
                iQuanView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iQuanView.fail(msg);
            }
        });
    }
}
