package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.HotModel;

import java.util.HashMap;

public interface HotContract {
    //创建一个实现类
    public abstract class IhotPresenter{
        public abstract void hot(HashMap<String,String> map);

    }
    //Model接口
    public interface IhotModel{
        public  void hot(HashMap<String,String>map, HotModel.HotModelCallBack hotModelCallBack);
    }
    //View接口
    public interface IhotView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
