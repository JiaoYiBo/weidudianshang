package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.AddressContract;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.RessModel;

import java.util.HashMap;

public class RessPresenter extends AddressContract.IRessPresenter {
    private final RessModel model;
    private AddressContract.IRessView iRessView;

    public RessPresenter(AddressContract.IRessView iRessView) {
        this.iRessView = iRessView;
        model =  new RessModel();
    }

    @Override
    public void ress(HashMap<String, String> map) {
        model.ress(map, new RessModel.RessModelCallBack() {
            @Override
            public void success(Object result) {
                iRessView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iRessView.fail(msg);
            }
        });
    }
}
