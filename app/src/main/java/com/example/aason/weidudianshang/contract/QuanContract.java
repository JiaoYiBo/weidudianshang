package com.example.aason.weidudianshang.contract;


import com.example.aason.weidudianshang.model.QuanModel;

import java.util.HashMap;

public interface QuanContract {
    //创建一个实现类
    public abstract class IQuanPresenter{
        public abstract void quan(HashMap<String,String> map);

    }
    //Model接口
    public interface IQuanModel{
        public  void quan(HashMap<String, String> map, QuanModel.QuanModelCallBack quanModelCallBack);
    }
    //View接口1
    public interface IQuanView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
