package com.example.aason.weidudianshang.net;

import com.example.aason.weidudianshang.bean.LoginBean;

public interface ResponseCallBcak {
    public void success(LoginBean loginBean);
    public void fail(String string);
}
