package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.MoAdapter;
import com.example.aason.weidudianshang.bean.MoBean;
import com.example.aason.weidudianshang.contract.MoContract;
import com.example.aason.weidudianshang.presenter.MoPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements MoContract.IMoView {

    private XRecyclerView rev;
    private MoPresenter moPresenter;
    private MoAdapter moAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rev = findViewById(R.id.rev);
        rev.setLayoutManager(new GridLayoutManager(this,3));
        moPresenter = new MoPresenter(this);
        moPresenter.getMo(new HashMap<String, String>());
        moAdapter = new MoAdapter(this);
        rev.setAdapter(moAdapter);
    }

    @Override
    public void success(Object result) {
        MoBean moBean = (MoBean) result;
        List<MoBean.ResultBean> result1 = moBean.getResult();
        moAdapter.setList(result1);
    }

    @Override
    public void fail(Object msg) {

    }
}
