package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.Rightdapter;
import com.example.aason.weidudianshang.bean.UserBean;
import com.example.aason.weidudianshang.contract.UserContract;
import com.example.aason.weidudianshang.presenter.UserPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FondActivity extends AppCompatActivity implements UserContract.IUserView {


    @BindView(R.id.popup)
    Button popup;
    @BindView(R.id.ed_text)
    EditText edit_text;
    @BindView(R.id.sou)
    TextView sou;
    @BindView(R.id.gv)
    GridView gv;
    private UserPresenter userPresenter;
    private String trim;
    private Rightdapter rightdapter;
    private HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fond);
        ButterKnife.bind(this);
        userPresenter = new UserPresenter(this);
        map = new HashMap<>();
        map.put("keyword","卫衣");
        map.put("page", 1+"");
        map.put("count",20+"");
        userPresenter.users(map);
    }

    @OnClick({R.id.popup, R.id.ed_text, R.id.sou})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.popup:
                Intent intent = new Intent(FondActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            case R.id.sou:
                trim = edit_text.getText().toString().trim();
                if (trim.equals("")) {
                    Toast.makeText(FondActivity.this,"关键字不能为空",Toast.LENGTH_SHORT).show();

                    return;
                }
                HashMap<String,String>map = new HashMap<>();
                    map.put("keyword",trim);
                    map.put("page", 1+"");
                    map.put("count",20+"");
                    userPresenter.users(map);

                break;

        }
    }

    @Override
    public void success(Object result) {
        UserBean userBean = (UserBean) result;
        rightdapter = new Rightdapter(this);
        gv.setAdapter(rightdapter);
        List<UserBean.ResultBean> result1 = userBean.getResult();
        rightdapter.setList(result1);

    }

    @Override
    public void fail(Object msg) {

    }

}
