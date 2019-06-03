package com.example.aason.weidudianshang.contract;


import com.example.aason.weidudianshang.model.FootModel;
import com.example.aason.weidudianshang.model.XiangModel;

import java.util.HashMap;

public interface FootContract {
    //创建一个实现类
    public abstract class IFootPresenter{
        public abstract void foot(HashMap<String,String> map,HashMap<String, String> params);

    }
    //Model接口
    public interface IFootModel{
        public  void foot(HashMap<String, String> map,HashMap<String, String> params, FootModel.FootModelCallBack footModelCallBack);
    }
    //View接口1
    public interface IFootView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
