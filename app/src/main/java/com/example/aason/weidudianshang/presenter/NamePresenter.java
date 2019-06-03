package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.NameContract;
import com.example.aason.weidudianshang.contract.TongContract;
import com.example.aason.weidudianshang.model.NameModel;
import com.example.aason.weidudianshang.model.TongModel;

import java.util.HashMap;

public class NamePresenter extends NameContract.INamePresenter {
    private final NameModel model;
    private NameContract.INameView iNameView;

    public NamePresenter(NameContract.INameView iNameView) {
        this.iNameView = iNameView;
        model =  new NameModel();
    }


    @Override
    public void names(HashMap<String, String> map, HashMap<String, String> param) {
        model.names(map,param, new NameModel.INameModelCallBack() {
            @Override
            public void success(Object result) {
                iNameView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iNameView.fail(msg);
            }
        });
    }
}
