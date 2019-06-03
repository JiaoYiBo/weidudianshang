package com.example.aason.weidudianshang.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.ShouAdapter;
import com.example.aason.weidudianshang.bean.ShouBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.contract.ShouContract;
import com.example.aason.weidudianshang.presenter.ShouPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class OrderFragment03_receive extends Fragment implements ShouContract.IShouView {

    private XRecyclerView rev;
    private ShouPresenter shouPresenter;
    private ShouAdapter shouAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentc, container, false);
        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        shouPresenter = new ShouPresenter(this);
        shouPresenter.getshou(new HashMap<String, String>());
        shouAdapter = new ShouAdapter(getActivity());
        rev.setAdapter(shouAdapter);
        return view;
    }

    @Override
    public void success(Object result) {
        ShouBean shouBean = (ShouBean) result;
        List<ShouBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = shouBean.getResult().getMlss().getCommodityList();
        shouAdapter.setList(commodityList);
    }

    @Override
    public void fail(Object msg) {

    }
}
