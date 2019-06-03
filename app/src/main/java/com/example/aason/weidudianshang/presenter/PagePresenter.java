package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.contract.PageContract;
import com.example.aason.weidudianshang.model.DingModel;
import com.example.aason.weidudianshang.model.PageModel;

import java.util.HashMap;

public class PagePresenter extends PageContract.IPagePresenter {
    private final PageModel model;
    private PageContract.IPageView iPageView;

    public PagePresenter(PageContract.IPageView iPageView) {
        this.iPageView = iPageView;
        model = new PageModel();
    }

    @Override
    public void getpag(HashMap<String, String> map) {
        model.getpag(map, new PageModel.PageModelCallBack() {
            @Override
            public void success(Object result) {
                iPageView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iPageView.fail(msg);
            }
        });
    }
}