package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.NameModel;

import java.util.HashMap;

public interface NameContract {
    //创建一个实现类
    public abstract class INamePresenter{
        public abstract void names(HashMap<String,String> map,HashMap<String,String> param);

    }
    //Model接口
    public interface INameModel{
        public  void names(HashMap<String, String> map,HashMap<String,String> param, NameModel.INameModelCallBack iNameModelCallBack);
    }
    //View接口
    public interface INameView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
