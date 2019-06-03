package com.example.aason.weidudianshang.contract;

import com.example.aason.weidudianshang.model.HotModel;
import com.example.aason.weidudianshang.model.UserModel;

import java.util.HashMap;

public interface UserContract {
    //创建一个实现类
    public abstract class IUserPresenter{
        public abstract void users(HashMap<String,String> map);

    }
    //Model接口
    public interface IUserModel{
        public  void users(HashMap<String, String> map, UserModel.UserModelCallBack userModelCallBack);
    }
    //View接口
    public interface IUserView{
        public void success(Object result);
        public void fail(Object msg);

    }
}
