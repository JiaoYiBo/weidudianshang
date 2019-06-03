package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.CartModel;
import com.example.aason.weidudianshang.model.RessModel;

import java.util.HashMap;

public interface AddressContract {
    //创建一个实现类
    public abstract class IRessPresenter{
        public abstract void ress(HashMap<String,String> map);

    }
    //Model接口
    public interface IRessModel{
        public  void ress(HashMap<String, String> map, RessModel.RessModelCallBack ressModelCallBack);
    }
    //View接口
    public interface IRessView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
