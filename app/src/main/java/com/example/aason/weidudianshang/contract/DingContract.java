package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.DingModel;

import java.util.HashMap;

public interface DingContract {
    public abstract class IDingPresenter{
        public abstract void getding(HashMap<String,String>map);
    }
    public interface IDingModel{
        public void getding(HashMap<String,String>map, DingModel.DingModelCallBack dingModelCallBack);
    }
    public interface IDingView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
