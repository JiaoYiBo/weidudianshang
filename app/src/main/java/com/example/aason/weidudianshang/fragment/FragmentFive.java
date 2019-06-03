package com.example.aason.weidudianshang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.avtivity.AddressActivity;
import com.example.aason.weidudianshang.avtivity.FootActivity;
import com.example.aason.weidudianshang.avtivity.GeActivity;
import com.example.aason.weidudianshang.avtivity.ManeyActivity;
import com.example.aason.weidudianshang.avtivity.WoActivity;
import com.leon.lib.settingview.LSettingItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentFive extends Fragment {


    @BindView(R.id.tv1)
    LSettingItem tv1;
    @BindView(R.id.tv2)
    LSettingItem tv2;
    @BindView(R.id.tv3)
    LSettingItem tv3;
    @BindView(R.id.tv4)
    LSettingItem tv4;
    @BindView(R.id.tv5)
    LSettingItem tv5;
    private View view;
    private Unbinder unbinder;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfive, container, false);
        unbinder = ButterKnife.bind(this, view);
        intData();
        return view;
    }

    private void intData() {
        tv1.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                intent = new Intent(getActivity(), GeActivity.class);
                startActivity(intent);
            }
        });
        tv2.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                intent = new Intent(getActivity(), WoActivity.class);
                startActivity(intent);
            }
        });
        //我的足迹
       tv3.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
           @Override
           public void click() {
               intent = new Intent(getActivity(), FootActivity.class);
               startActivity(intent);
           }
       });
       tv4.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
           @Override
           public void click() {
               intent = new Intent(getActivity(), ManeyActivity.class);
               startActivity(intent);
           }
       });
        tv5.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                intent = new Intent(getActivity(), AddressActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
