package com.example.aason.weidudianshang.avtivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.QuanAdapter;
import com.example.aason.weidudianshang.adapter.WoquanAdapter;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.example.aason.weidudianshang.contract.QuanContract;
import com.example.aason.weidudianshang.presenter.QuanPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class WoActivity extends AppCompatActivity implements QuanContract.IQuanView {
    private XRecyclerView src;
    private QuanPresenter quanPresenter;
    private int page=1;
    private WoquanAdapter woquanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo);
        src = findViewById(R.id.src);
        src.setLayoutManager(new LinearLayoutManager(this));
        quanPresenter = new QuanPresenter(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("page","2");
        map.put("count","2");
        quanPresenter.quan(map);
    }

    @Override
    public void success(Object result) {
        QuanBean quanBean = (QuanBean) result;
        List<QuanBean.ResultBean> result1 = quanBean.getResult();
        Toast.makeText(this,quanBean+""+"",Toast.LENGTH_LONG).show();
        woquanAdapter = new WoquanAdapter(this);
        woquanAdapter.setList(result1);
        src.setAdapter(woquanAdapter);
    }

    @Override
    public void fail(Object msg) {

    }
}
