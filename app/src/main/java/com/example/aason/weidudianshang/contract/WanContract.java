package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.PinModel;
import com.example.aason.weidudianshang.model.WanModel;

import java.util.HashMap;

public interface WanContract {
    public abstract class IWanPresenter{
        public abstract void getwan(HashMap<String,String>map);
    }
    public interface IWanModel{
        public void getwan(HashMap<String, String> map, WanModel.WanModelCallBack wanModelCallBack);
    }
    public interface IWanView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
