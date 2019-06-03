package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.PageModel;
import com.example.aason.weidudianshang.model.PinModel;

import java.util.HashMap;

public interface PinContract {
    public abstract class IPinPresenter{
        public abstract void getpin(HashMap<String,String>map);
    }
    public interface IPinModel{
        public void getpin(HashMap<String, String> map, PinModel.PinModelCallBack pinModelCallBack);
    }
    public interface IPinView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
