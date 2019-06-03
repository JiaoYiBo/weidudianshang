package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.LoginBean;
import com.example.aason.weidudianshang.contract.LoginContract;
import com.example.aason.weidudianshang.presenter.LoginPresenter;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements LoginContract.ILoginView {

    private EditText mobile;
    private EditText password;
    private Button login;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    private void initView() {
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        loginPresenter = new LoginPresenter(this);
    }
    public void Regs(View view) {
        Intent intent = new Intent(RegActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void Regg(View view) {
        HashMap<String,String> map = new HashMap<>();
        map.put("phone",mobile.getText().toString().trim());
        map.put("pwd",password.getText().toString().trim());
        loginPresenter.reg(map);
    }


    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this,loginBean.getMessage()+"",Toast.LENGTH_SHORT).show();
        if (loginBean.getMessage().equals("注册成功")) {
            Intent intent = new Intent(RegActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void fail(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}
