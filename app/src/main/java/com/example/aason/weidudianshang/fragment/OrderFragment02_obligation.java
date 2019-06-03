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
import com.example.aason.weidudianshang.adapter.PageAdapter;
import com.example.aason.weidudianshang.bean.PageBean;
import com.example.aason.weidudianshang.contract.PageContract;
import com.example.aason.weidudianshang.presenter.PagePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class OrderFragment02_obligation extends Fragment implements PageContract.IPageView {

    private XRecyclerView rev;
    private PagePresenter pagePresenter;
    private PageAdapter pageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        pagePresenter = new PagePresenter(this);
        pagePresenter.getpag(new HashMap<String, String>());
        pageAdapter = new PageAdapter(getActivity());
        rev.setAdapter(pageAdapter);
        return view;
    }

    @Override
    public void success(Object result) {
        PageBean pageBean = (PageBean) result;
        List<PageBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pageBean.getResult().getPzsh().getCommodityList();
        pageAdapter.setList(commodityList);
    }

    @Override
    public void fail(Object msg) {

    }
}
