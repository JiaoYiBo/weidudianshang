package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.PinModel;
import com.example.aason.weidudianshang.model.PinsModel;

import java.util.HashMap;

public interface PinsContract {
    public abstract class IPinPresenter{
        public abstract void getpins(HashMap<String,String>map);
    }
    public interface IPinModel{
        public void getpins(HashMap<String, String> map, PinsModel.PinsModelCallBack pinsModelCallBack);
    }
    public interface IPinView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
