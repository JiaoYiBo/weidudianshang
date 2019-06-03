package com.example.aason.weidudianshang.avtivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.XiuBean;
import com.example.aason.weidudianshang.contract.NameContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.NamePresenter;

import java.util.HashMap;

public class GeActivity extends AppCompatActivity implements NameContract.INameView {

    private TextView name;
    private TextView pwd;
    private NamePresenter namePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge);
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et = new EditText(GeActivity.this);
                new AlertDialog.Builder(GeActivity.this).setTitle("请输入消息")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                namePresenter = new NamePresenter(GeActivity.this);
                                HashMap<String, String> param = new HashMap<>();
                                param.put("nickName",et.getText().toString());
                                String userId = (String) SpUtils.getInstance().getData("userId", "");
                                String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
                                HashMap<String, String> map = new HashMap<>();
                                map.put("userId",userId);
                                map.put("sessionId",sessionId);
                                namePresenter.names(map,param);
                                name.setText(et.getText().toString());
                               Toast.makeText(getApplicationContext(), et.getText().toString(),Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("取消",null)
                        .show();}
        });
        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et = new EditText(GeActivity.this);
                new AlertDialog.Builder(GeActivity.this).setTitle("修改密码")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                namePresenter = new NamePresenter(GeActivity.this);
                                HashMap<String, String> param = new HashMap<>();
                                param.put("nickName",et.getText().toString());
                                String userId = (String) SpUtils.getInstance().getData("userId", "");
                                String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
                                HashMap<String, String> map = new HashMap<>();
                                map.put("userId",userId);
                                map.put("sessionId",sessionId);
                                namePresenter.names(map,param);
                                name.setText(et.getText().toString());
                                Toast.makeText(getApplicationContext(), et.getText().toString(),Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("取消",null)
                        .show();}
        });
    }

    @Override
    public void success(Object result) {
        XiuBean xiuBean = (XiuBean) result;
        if (xiuBean.getStatus().equals("0000")) {
            Toast.makeText(this, ""+xiuBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail(Object msg) {

    }
}
