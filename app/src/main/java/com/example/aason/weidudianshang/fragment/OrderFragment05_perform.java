package com.example.aason.weidudianshang.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.WanAdapter;
import com.example.aason.weidudianshang.bean.WanBean;
import com.example.aason.weidudianshang.contract.WanContract;
import com.example.aason.weidudianshang.presenter.WanPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class OrderFragment05_perform extends Fragment implements WanContract.IWanView {
    /*private Button popupwindow;
    private PopupWindow mpopupwindow;
    boolean flag = true;*/
    private XRecyclerView rev;
    private WanPresenter wanPresenter;
    private WanAdapter wanAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmente, container, false);
        rev = view.findViewById(R.id.rev);
        rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        wanPresenter = new WanPresenter(this);
        wanPresenter.getwan(new HashMap<String, String>());
        wanAdapter = new WanAdapter(getActivity());
        rev.setAdapter(wanAdapter);
       /* popupwindow = (Button)view.findViewById(R.id.popup);
        popupwindow.setOnClickListener(new popupwindowListener());*/
        return view;
    }

    @Override
    public void success(Object result) {
        WanBean wanBean = (WanBean) result;
        List<WanBean.ResultBean> result1 = wanBean.getResult();
        wanAdapter.setList(result1);
    }

    @Override
    public void fail(Object msg) {

    }
   /* //popwindow弹框
    public class popupwindowListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (flag){
                showpopupwindow();
                mpopupwindow.showAsDropDown(v);
                flag = false;
            }else if (!flag){
                mpopupwindow.dismiss();
                flag=true;
            }

        }
    }
    private void showpopupwindow(){
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pops, null);//设置contentview
        mpopupwindow = new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置线性默认宽高
    }*/
}
