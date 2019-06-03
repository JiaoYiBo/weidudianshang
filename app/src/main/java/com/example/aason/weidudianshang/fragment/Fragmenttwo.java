package com.example.aason.weidudianshang.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.QuanAdapter;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.example.aason.weidudianshang.contract.QuanContract;
import com.example.aason.weidudianshang.presenter.QuanPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class Fragmenttwo extends Fragment implements QuanContract.IQuanView {

    private XRecyclerView rev;
    private QuanPresenter quanPresenter;
    private QuanAdapter quanAdapter;
    private int page=1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,container,false);

        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        quanPresenter = new QuanPresenter(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("page","2");
        map.put("count","45");
        quanPresenter.quan(map);

        return view;
    }

    @Override
    public void success(Object result) {
        QuanBean quanBean = (QuanBean) result;
        List<QuanBean.ResultBean> result1 = quanBean.getResult();
        //Toast.makeText(getActivity(),quanBean+""+"",Toast.LENGTH_LONG).show();
        quanAdapter = new QuanAdapter(getActivity());
        quanAdapter.setList(result1);
        rev.setAdapter(quanAdapter);
        rev.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page++;
                HashMap<String, String> map = new HashMap<>();
                map.put("page","1");
                map.put("count","10");
                quanPresenter.quan(map);
                rev.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                HashMap<String, String> map = new HashMap<>();
                map.put("page","1");
                map.put("count","20");
                quanPresenter.quan(map);
                rev.loadMoreComplete();
            }
        });
    }

    @Override
    public void fail(Object msg) {
        //Toast.makeText(getActivity(),msg+""+"",Toast.LENGTH_LONG).show();
    }
}
