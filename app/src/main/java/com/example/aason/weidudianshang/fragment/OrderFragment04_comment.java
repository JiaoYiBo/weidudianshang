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
import com.example.aason.weidudianshang.adapter.PinAdapter;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.contract.PinContract;
import com.example.aason.weidudianshang.presenter.PinPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class OrderFragment04_comment extends Fragment implements PinContract.IPinView {

    private XRecyclerView rev;
    private PinPresenter pinPresenter;
    private PinAdapter pinAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentd, container, false);
        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        pinPresenter = new PinPresenter(this);
        pinPresenter.getpin(new HashMap<String, String>());
        pinAdapter = new PinAdapter(getActivity());
        rev.setAdapter(pinAdapter);
        return view;
    }

    @Override
    public void success(Object result) {
        PinBean pinBean = (PinBean) result;
        List<PinBean.ResultBean> result1 = pinBean.getResult();
        pinAdapter.setList(result1);

    }

    @Override
    public void fail(Object msg) {

    }
}
