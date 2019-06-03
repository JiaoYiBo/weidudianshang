package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.ReModel;

import java.util.HashMap;

public interface ReContract{
    public abstract class IRePresneter{
        public abstract void getRe(HashMap<String,String>map);
    }
    public interface IReModel{
        public void getRe(HashMap<String,String>map,ReModel.ReModelCallBack reModelCallBack);
    }
    public interface IReView{
        public void  success(Object result);
        public void  fail(Object msg);
    }
}
