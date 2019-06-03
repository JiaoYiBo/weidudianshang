package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.HotModel;

import java.util.HashMap;

public interface CartContract {
    //创建一个实现类
    public abstract class ICartPresenter{
        public abstract void cart(HashMap<String,String> map);

    }
    //Model接口
    public interface ICartModel{
        public  void cart(HashMap<String, String> map, CartModel.CartModelCallBack cartModelCallBack);
    }
    //View接口
    public interface ICartView{
        public void onsuccess(Object result);
        public void onfail(Object msg);

    }
}
