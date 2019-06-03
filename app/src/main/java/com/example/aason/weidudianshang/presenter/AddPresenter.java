package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.AddContract;
import com.example.aason.weidudianshang.contract.AddressContract;
import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.model.AddModel;
import com.example.aason.weidudianshang.model.FootModel;

import java.util.HashMap;

public class AddPresenter extends AddContract.IAddPresenter {
    private final AddModel model;
    private AddContract.IAddView iAddView;

    public AddPresenter(AddContract.IAddView iAddView) {
        this.iAddView = iAddView;
        model = new AddModel();
    }

    @Override
    public void adds(HashMap<String, String> map, HashMap<String, String> params) {
        model.adds(map, params, new AddModel.AddModelCallBack() {
            @Override
            public void success(Object result) {
                iAddView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iAddView.fail(msg);
            }
        });
    }
}
