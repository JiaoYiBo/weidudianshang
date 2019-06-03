package com.example.aason.weidudianshang.model;

import com.example.aason.weidudianshang.api.UserService;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.bean.PageBean;
import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.contract.PageContract;
import com.example.aason.weidudianshang.net.ResfateUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PageModel implements PageContract.IPageModel {


    @Override
    public void getpag(HashMap<String, String> map, final PageModelCallBack PageModelCallBack) {
        ResfateUtils.getmInstance().create(UserService.class)
                .getpag(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PageBean>() {
                    @Override
                    public void accept(PageBean pageBean) throws Exception {
                        List<PageBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pageBean.getResult().getPzsh().getCommodityList();
                        if (commodityList != null) {
                            PageModelCallBack.success(pageBean);
                        } else {
                            PageModelCallBack.fail(pageBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print(throwable);
                    }
                });
    }

    public interface PageModelCallBack{
        public void success(Object result);
        public void fail(Object msg);
    }
}
