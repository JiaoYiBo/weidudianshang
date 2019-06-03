package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.HotModel;

import java.util.HashMap;

public class CartPresenter extends CartContract.ICartPresenter {
    private final CartModel model;
    private CartContract.ICartView iCartView;

    public CartPresenter(CartContract.ICartView iCartView) {
        this.iCartView = iCartView;
        model =  new CartModel();
    }

    @Override
    public void cart(HashMap<String, String> map) {
        model.cart(map, new CartModel.CartModelCallBack() {
            @Override
            public void success(Object result) {
                iCartView.onsuccess(result);
            }

            @Override
            public void fail(Object msg) {
                iCartView.onfail(msg);
            }
        });
    }
}
