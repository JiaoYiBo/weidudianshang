package com.example.aason.weidudianshang.presenter;

import com.example.aason.weidudianshang.contract.UserContract;
import com.example.aason.weidudianshang.contract.XiangContract;
import com.example.aason.weidudianshang.model.UserModel;
import com.example.aason.weidudianshang.model.XiangModel;

import java.util.HashMap;

public class UserPresenter extends UserContract.IUserPresenter {
    private final UserModel model;
    private UserContract.IUserView iUserView;

    public UserPresenter(UserContract.IUserView iUserView) {
        this.iUserView = iUserView;
         model=new UserModel();
    }

    @Override
    public void users(HashMap<String, String> map) {
        model.users(map, new UserModel.UserModelCallBack() {
            @Override
            public void success(Object result) {
                iUserView.success(result);
            }

            @Override
            public void fail(Object msg) {
                iUserView.fail(msg);
            }
        });
    }
}

