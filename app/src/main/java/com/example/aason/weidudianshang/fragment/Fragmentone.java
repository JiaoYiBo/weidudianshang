package com.example.aason.weidudianshang.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.MoLiAdapter;
import com.example.aason.weidudianshang.adapter.PinzhiAdapter;
import com.example.aason.weidudianshang.adapter.Rexiaodapter;
import com.example.aason.weidudianshang.avtivity.FirstActivity;
import com.example.aason.weidudianshang.avtivity.FondActivity;
import com.example.aason.weidudianshang.avtivity.Main2Activity;
import com.example.aason.weidudianshang.avtivity.SecondActivity;
import com.example.aason.weidudianshang.avtivity.ThirdActivity;
import com.example.aason.weidudianshang.avtivity.XiangActivity;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.bean.UserBean;
import com.example.aason.weidudianshang.bean.XiangBean;
import com.example.aason.weidudianshang.contract.HotContract;
import com.example.aason.weidudianshang.contract.UserContract;
import com.example.aason.weidudianshang.contract.XiangContract;
import com.example.aason.weidudianshang.presenter.HotPresenter;
import com.example.aason.weidudianshang.presenter.UserPresenter;
import com.example.aason.weidudianshang.presenter.XiangPresenter;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragmentone extends Fragment implements HotContract.IhotView{
    @BindView(R.id.gv)
    GridView gv;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.gv1)
    GridView gv1;
    private XBanner myxbanner;
    private HotPresenter hotPresenter;
    private MoLiAdapter moLiAdapter;
    private View view;
    private Unbinder unbinder;
    private PinzhiAdapter pinzhiAdapter;
    private Rexiaodapter rexiaodapter;
    private Button popupwindow;
    private PopupWindow mpopupwindow;
    boolean flag = true;
    private List<ShowBean.ResultBean.RxxpBean.CommodityListBean> commodityList2;
    private List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1;
    private List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList;
    private TextView sou;
    private EditText edit_text;
    private TextView dian,dian1,dian2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentone, container, false);
        sou = view.findViewById(R.id.sou);
        dian = view.findViewById(R.id.dian);
        dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FirstActivity.class);
                startActivity(intent);
            }
        });
        dian1 = view.findViewById(R.id.dian1);
        dian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });
        dian2 = view.findViewById(R.id.dian2);
        dian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThirdActivity.class);
                startActivity(intent);
            }
        });
        edit_text = view.findViewById(R.id.ed_text);
        edit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FondActivity.class);
                startActivity(intent);
            }
        });
        hotPresenter = new HotPresenter(this);
        hotPresenter.hot(new HashMap<String, String>());
        popupwindow = view.findViewById(R.id.popup);
        popupwindow.setOnClickListener(new popupwindowListener());
        myxbanner = view.findViewById(R.id.myxbanner);
        //轮播图
        final List<String> image = new ArrayList<>();

        image.add("http://mobile.bwstudent.com/images/small/banner/hzp.png");
        image.add("http://mobile.bwstudent.com/images/small/banner/px.png");
        image.add("http://mobile.bwstudent.com/images/small/banner/cj.png");
        image.add("http://mobile.bwstudent.com/images/small/banner/wy.png");
        image.add("http://mobile.bwstudent.com/images/small/banner/lyq.png");
        myxbanner.setData(image, null);
        myxbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(image.get(position)).into((ImageView) view);
            }
        });
        myxbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void success(Object result) {

        ShowBean showBean = (ShowBean) result;
        //魔力时尚
        moLiAdapter = new MoLiAdapter(getActivity());
        lv.setAdapter(moLiAdapter);
        commodityList = showBean.getResult().getMlss().getCommodityList();
        moLiAdapter.setList(commodityList);
        //魔力时尚详情页面
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("id",commodityList.get(position).getCommodityId());
                intent.putExtra("userId","userId");
                intent.putExtra("sessionId","sessionId");
                startActivity(intent);
            }
        });
        //品质生活
        pinzhiAdapter = new PinzhiAdapter(getActivity());
        gv1.setAdapter(pinzhiAdapter);
        commodityList1 = showBean.getResult().getPzsh().getCommodityList();
        pinzhiAdapter.setList(commodityList1);
        //品质生活详情页面
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("id",commodityList1.get(position).getCommodityId());
                startActivity(intent);
            }
        });
        ///热销新品
        rexiaodapter = new Rexiaodapter(getActivity());
        gv.setAdapter(rexiaodapter);
        commodityList2 = showBean.getResult().getRxxp().getCommodityList();
        rexiaodapter.setList(commodityList2);
        //热销新品详情
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("id",commodityList2.get(position).getCommodityId());
                startActivity(intent);
            }
        });
    }
    //失败的方法
    @Override
    public void fail(Object msg) {

    }
    //内存泄漏
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //popwindow弹框
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
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null);//设置contentview
        mpopupwindow = new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置线性默认宽高
    }

}
