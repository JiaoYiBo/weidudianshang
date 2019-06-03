package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.contract.TongContract;
import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.TongModel;

import java.util.HashMap;

public class TongPresenter extends TongContract.ITongPresenter {
    private final TongModel model;
    private TongContract.ITongView iTongView;

    public TongPresenter(TongContract.ITongView iTongView) {
        this.iTongView = iTongView;
        model =  new TongModel();
    }

    @Override
    public void tong(HashMap<String, String> map,String tong) {
        model.tong(map,tong, new TongModel.TongModelCallBack() {
            @Override
            public void success(Object result) {
                iTongView.tongsuccess(result);
            }

            @Override
            public void fail(Object msg) {
                iTongView.tongfail(msg);
            }
        });
    }
}
