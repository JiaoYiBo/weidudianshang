package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.HotAdapter;
import com.example.aason.weidudianshang.bean.HotBean;
import com.example.aason.weidudianshang.contract.ReContract;
import com.example.aason.weidudianshang.presenter.RePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements ReContract.IReView {

    private XRecyclerView rev;

    private HotAdapter hotAdapter;
    private RePresenter rePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        rev = findViewById(R.id.rev);
        rev.setLayoutManager(new GridLayoutManager(this,3));
        rePresenter = new RePresenter(this);
        rePresenter.getRe(new HashMap<String, String>());
        hotAdapter = new HotAdapter(this);
        rev.setAdapter(hotAdapter);
    }

    @Override
    public void success(Object result) {
        HotBean hotBean = (HotBean) result;
        List<HotBean.ResultBean> result1 = hotBean.getResult();
        hotAdapter.setList(result1);
    }

    @Override
    public void fail(Object msg) {

    }
}
