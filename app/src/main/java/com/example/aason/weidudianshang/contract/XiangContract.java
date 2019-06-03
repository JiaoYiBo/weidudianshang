package com.example.aason.weidudianshang.contract;


import com.example.aason.weidudianshang.model.QuanModel;
import com.example.aason.weidudianshang.model.XiangModel;

import java.util.HashMap;

public interface XiangContract {
    //创建一个实现类
    public abstract class IXiangPresenter{
        public abstract void xiang(HashMap<String,String> map);

    }
    //Model接口
    public interface IXiangModel{
        public  void xiang(HashMap<String, String> map, XiangModel.XiangModelCallBack xiangModelCallBack);
    }
    //View接口1
    public interface IXiangView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
