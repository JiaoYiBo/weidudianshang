package com.example.aason.weidudianshang.presenter;


import com.example.aason.weidudianshang.api.LoginApi;
import com.example.aason.weidudianshang.bean.LoginBean;
import com.example.aason.weidudianshang.contract.LoginContract;
import com.example.aason.weidudianshang.model.LoginModel;
import com.example.aason.weidudianshang.net.ResponseCallBcak;
import com.example.aason.weidudianshang.utils.ValidatorUtil;

import java.util.HashMap;

public class LoginPresenter extends LoginContract.ILoginPresenter {
    private final LoginModel model;
    private  LoginContract.ILoginView iLoginView;

    public LoginPresenter(LoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        model = new LoginModel();
    }

    @Override
    public void login(HashMap<String, String> map) {
        String mobile = map.get("phone");
        if(!ValidatorUtil.isMobile(mobile)){
            iLoginView.fail("手机号不合法");
        }
      model.setOkhttp(map, LoginApi.Login_Api, new ResponseCallBcak() {
          @Override
          public void success(LoginBean loginBean) {
              if (loginBean!= null) {
                  iLoginView.success(loginBean);
              }
          }

          @Override
          public void fail(String string) {
                iLoginView.fail(string);
          }
      });
    }

    @Override
    public void reg(HashMap<String, String> map) {
        String mobile = map.get("phone");
        if(!ValidatorUtil.isMobile(mobile)){
            iLoginView.fail("手机号不合法");
        }
        model.setOkhttp(map, LoginApi.Reg_Api, new ResponseCallBcak() {
            @Override
            public void success(LoginBean loginBean) {
                if (loginBean!= null) {
                    iLoginView.success(loginBean);
                }
            }

            @Override
            public void fail(String string) {
                iLoginView.fail(string);
            }
        });
    }
}
