package com.example.aason.weidudianshang.avtivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.LoginBean;
import com.example.aason.weidudianshang.contract.LoginContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.LoginPresenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView {
    private SharedPreferences sp;
    private CheckBox rember_checkbox;
    @BindView(R.id.eye)
    ImageView mEye;
    private EditText edit_username;
    private EditText edit_password;
    private Button login;
    private LoginPresenter loginPresenter;
    private boolean isYeye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        initView();
    }

    @SuppressLint("WrongConstant")
    private void initView() {
        edit_username = findViewById(R.id.mobile);
        edit_password = findViewById(R.id.passwordEdit);
        login = findViewById(R.id.login);
        rember_checkbox=findViewById(R.id.rememberPass);
        //记住密码
        sp = getSharedPreferences("login", Context.MODE_APPEND);
        //判断选中
        if (sp.getBoolean("remober",false)) {
            String phone = sp.getString("phone", "");
            String pass = sp.getString("pwd", "");
            edit_password.setText(pass);
            edit_username.setText(phone);
            rember_checkbox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit_username.getText().toString();
                String pass = edit_password.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pass);
                loginPresenter.login(map);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("remober",rember_checkbox.isChecked());
                edit.putString("phone",phone);
                edit.putString("pwd",pass);
                edit.commit();
            }
        });
        //友盟第三方登录
        loginPresenter = new LoginPresenter(this);
        if (Build.VERSION.SDK_INT >= 23) {//QQ需要申请写入权限
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        final UMShareAPI umShareAPI = UMShareAPI.get(this);
    }

    public void login(View view) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", edit_username.getText().toString().trim());
        map.put("pwd", edit_password.getText().toString().trim());
        loginPresenter.login(map);
    }

    public void Reg(View view) {
        Intent intent = new Intent(LoginActivity.this, RegActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage() + "", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor edit = sp.edit();
        SpUtils.getInstance().saveData("userId",loginBean.getResult().getUserId()+"");
        SpUtils.getInstance().saveData("sessionId",loginBean.getResult().getSessionId()+"");
        edit.commit();//提交

        Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void fail(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void error(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
    //明文密文切换密码
    @OnClick(R.id.eye)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.eye:
                isYeye=true;
                mEye.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isYeye){
                            edit_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            isYeye =false;
                        }else {
                            edit_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            isYeye =true;
                        }
                    }
                });

                break;
        }
    }
}
