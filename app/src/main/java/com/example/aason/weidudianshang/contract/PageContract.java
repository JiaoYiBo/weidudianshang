package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.DingModel;
import com.example.aason.weidudianshang.model.PageModel;

import java.util.HashMap;

public interface PageContract {
    public abstract class IPagePresenter{
        public abstract void getpag(HashMap<String,String>map);
    }
    public interface IPageModel{
        public void getpag(HashMap<String, String> map, PageModel.PageModelCallBack PageModelCallBack);
    }
    public interface IPageView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
