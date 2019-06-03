package com.example.aason.weidudianshang.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.CartAdapter;
import com.example.aason.weidudianshang.bean.CartBean;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.callback.CartCallback;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.CartPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class Fragmentthree extends Fragment implements CartContract.ICartView,CartCallback{


    private CartPresenter cartPresenter;
    private CartAdapter cartAdapter;
    private XRecyclerView rev;
    private CheckBox ck;
    private List<ChaBean.ResultBean> result1;
    private ChaBean chaBean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentthree,container,false);
        rev = view.findViewById(R.id.rev);
        ck = view.findViewById(R.id.ck);
        ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for(ChaBean.ResultBean cart: chaBean.getResult()){
                    cart.isChecked =isChecked;
                }
                cartAdapter.notifyDataSetChanged();
                getTouchPrice();
            }
        });
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        String userId = (String) SpUtils.getInstance().getData("userId", "");
       String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
        cartAdapter = new CartAdapter(getActivity());
        rev.setAdapter(cartAdapter);
        cartPresenter = new CartPresenter(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("sessionId",sessionId);
        cartPresenter.cart(map);
        return view;
    }

    @Override
    public void onsuccess(Object result) {
        chaBean = (ChaBean) result;
        result1 = chaBean.getResult();
        cartAdapter.setList(result1);
        cartAdapter.setCartCallBack(this);
    }

    @Override
    public void onfail(Object msg) {

    }
    private void getTouchPrice() {
        double touchprice=0;
        for (ChaBean.ResultBean resultBean : chaBean.getResult()) {
            if (resultBean.isChecked){
                touchprice += resultBean.getPrice()*resultBean.productNum;
            }
        }
        ck.setText("￥:"+touchprice);
    }

    @Override
    public void notifyCartItem(boolean isChecked) {
        ck.setChecked(isChecked);
    }

    @Override
    public void notifyNum() {
        getTouchPrice();
    }
}
