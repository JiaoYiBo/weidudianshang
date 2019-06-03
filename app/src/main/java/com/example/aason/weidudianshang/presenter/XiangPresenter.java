package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.XiangContract;
import com.example.aason.weidudianshang.model.HotModel;
import com.example.aason.weidudianshang.model.XiangModel;

import java.util.HashMap;

public class XiangPresenter extends XiangContract.IXiangPresenter {
    private final XiangModel model;
    private XiangContract.IXiangView iXiangView;

    public XiangPresenter(XiangContract.IXiangView iXiangView) {
        this.iXiangView = iXiangView;
        model = new XiangModel();
    }

    @Override
    public void xiang(HashMap<String, String> map) {
        model.xiang(map, new XiangModel.XiangModelCallBack() {
            @Override
            public void success(Object result) {
                iXiangView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iXiangView.fail(msg);
            }
        });
    }
}
