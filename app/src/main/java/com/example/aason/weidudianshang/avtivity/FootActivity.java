package com.example.aason.weidudianshang.avtivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.FootAdapter;
import com.example.aason.weidudianshang.bean.FootBean;
import com.example.aason.weidudianshang.contract.FootContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.FootPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class FootActivity extends AppCompatActivity implements FootContract.IFootView {

    private RecyclerView rev;
    private FootAdapter footAdapter;
    private FootPresenter footPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);
        rev = findViewById(R.id.rev);

        footPresenter = new FootPresenter(this);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String,String>params = new HashMap<>();
        map.put("page","1");
        map.put("count","20");
        String userId = (String) SpUtils.getInstance().getData("userId", "");
        String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
        params.put("userId",userId);
        params.put("sessionId",sessionId);
        Log.i("TAST=",userId);
        Log.i("TAST=",sessionId);
        footPresenter.foot(map,params);


    }

    @Override
    public void success(Object result) {
        FootBean footBean = (FootBean) result;
        footAdapter = new FootAdapter(this);
        List<FootBean.ResultBean> result1 = footBean.getResult();
        footAdapter.setList(result1);
        rev.setAdapter(footAdapter);
        rev.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void fail(Object msg) {

    }
}
