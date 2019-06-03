package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.MoModel;
import com.example.aason.weidudianshang.model.ReModel;

import java.util.HashMap;

public interface MoContract {
    public abstract class IMoPresneter{
        public abstract void getMo(HashMap<String,String>map);
    }
    public interface IMoModel{
        public void getMo(HashMap<String, String> map, MoModel.MoModelCallBack moModelCallBack);
    }
    public interface IMoView{
        public void  success(Object result);
        public void  fail(Object msg);
    }
}
