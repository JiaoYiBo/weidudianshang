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
import com.example.aason.weidudianshang.adapter.DingAdapter;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.contract.DingContract;
import com.example.aason.weidudianshang.presenter.DingPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class OrderFragment01_all extends Fragment implements DingContract.IDingView {

    private XRecyclerView rev;
    private DingPresenter dingPresenter;
    private DingAdapter dingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);
        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        dingPresenter = new DingPresenter(this);
        dingPresenter.getding(new HashMap<String, String>());
        dingAdapter = new DingAdapter(getActivity());
        rev.setAdapter(dingAdapter);
        return view;
    }

    @Override
    public void success(Object result) {
        DingBean dingBean = (DingBean) result;
        List<DingBean.ResultBean.RxxpBean.CommodityListBean> commodityList = dingBean.getResult().getRxxp().getCommodityList();
        dingAdapter.setList(commodityList);

    }

    @Override
    public void fail(Object msg) {

    }
}
