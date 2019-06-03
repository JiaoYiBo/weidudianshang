package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.DingModel;
import com.example.aason.weidudianshang.model.ShouModel;

import java.util.HashMap;

public interface ShouContract {
    public abstract class IShouPresenter{
        public abstract void getshou(HashMap<String,String>map);
    }
    public interface IShouModel{
        public void getshou(HashMap<String, String> map,ShouModel.ShouModelCallBack shouModelCallBack);
    }
    public interface IShouView{
        public void success(Object result);
        public void fail(Object msg);
    }
}
