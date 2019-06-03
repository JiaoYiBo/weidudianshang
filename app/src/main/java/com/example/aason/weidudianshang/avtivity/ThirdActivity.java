package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.PinsAdapter;
import com.example.aason.weidudianshang.bean.PinZhiBean;
import com.example.aason.weidudianshang.contract.PinsContract;
import com.example.aason.weidudianshang.presenter.PinsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class ThirdActivity extends AppCompatActivity implements PinsContract.IPinView {

    private XRecyclerView rev;
    private PinsPresenter pinsPresenter;
    private PinsAdapter pinsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        rev = findViewById(R.id.rev);
        rev.setLayoutManager(new GridLayoutManager(this,3));
        pinsPresenter = new PinsPresenter(this);
        pinsPresenter.getpins(new HashMap<String, String>());
        pinsAdapter = new PinsAdapter(this);
        rev.setAdapter(pinsAdapter);
    }

    @Override
    public void success(Object result) {
        PinZhiBean pinZhiBean = (PinZhiBean) result;
        List<PinZhiBean.ResultBean> result1 = pinZhiBean.getResult();
        pinsAdapter.setList(result1);

    }

    @Override
    public void fail(Object msg) {

    }
}
