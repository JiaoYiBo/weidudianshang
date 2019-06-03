package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.TongModel;

import java.util.HashMap;

public interface TongContract {
    //创建一个实现类
    public abstract class ITongPresenter{
        public abstract void tong(HashMap<String,String> map,String tong);

    }
    //Model接口
    public interface ITongModel{
        public  void tong(HashMap<String, String> map,String tong,TongModel.TongModelCallBack tongModelCallBack);
    }
    //View接口
    public interface ITongView{
        public void tongsuccess(Object result);
        public void tongfail(Object msg);

    }
}
