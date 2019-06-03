package com.example.aason.weidudianshang.contract;


import com.example.aason.weidudianshang.model.AddModel;
import com.example.aason.weidudianshang.model.FootModel;

import java.util.HashMap;

public interface AddContract {
    //创建一个实现类
    public abstract class IAddPresenter{
        public abstract void adds(HashMap<String,String> map,HashMap<String, String> params);

    }
    //Model接口
    public interface IAddModel{
        public  void adds(HashMap<String, String> map, HashMap<String, String> params, AddModel.AddModelCallBack addModelCallBack);
    }
    //View接口1
    public interface IAddView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
