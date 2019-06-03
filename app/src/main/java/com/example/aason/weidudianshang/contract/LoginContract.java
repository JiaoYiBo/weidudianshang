package com.example.aason.weidudianshang.contract;


import com.example.aason.weidudianshang.bean.LoginBean;
import com.example.aason.weidudianshang.net.ResponseCallBcak;

import java.util.HashMap;

public interface LoginContract {
    //创建一个实现类
    public abstract class ILoginPresenter{
        public abstract void login(HashMap<String,String>map);
        public abstract void reg(HashMap<String,String>map);
    }
    //Model接口
    public interface ILoginModel{
        public  void setOkhttp(HashMap<String, String> map, String string, ResponseCallBcak callBcak);
    }
    //View接口
    public interface ILoginView{
        public void success(LoginBean loginBean);
        public void fail(String string);
        public void error(String error);
    }
}
