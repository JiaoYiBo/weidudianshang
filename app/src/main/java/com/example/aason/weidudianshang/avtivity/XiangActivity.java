package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.bean.ShangpinBean;
import com.example.aason.weidudianshang.bean.TongBean;
import com.example.aason.weidudianshang.bean.XiangBean;
import com.example.aason.weidudianshang.contract.CartContract;
import com.example.aason.weidudianshang.contract.TongContract;
import com.example.aason.weidudianshang.contract.XiangContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.CartPresenter;
import com.example.aason.weidudianshang.presenter.TongPresenter;
import com.example.aason.weidudianshang.presenter.XiangPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangActivity extends AppCompatActivity implements XiangContract.IXiangView,CartContract.ICartView,TongContract.ITongView {
    @BindView(R.id.xbander)
    XBanner xbander;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.kilo)
    TextView kilo;
    @BindView(R.id.wv)
    WebView wv;

    private int page;
    private XiangPresenter xiangPresenter;
    private XRecyclerView rev;
    private XiangBean xiangBean;
    private ImageView cart;
    private List<ShangpinBean> list = new ArrayList<>();
    private CartPresenter cartPresenter;
    private int commodityId;
    private TongPresenter tongPresenter;
    private HashMap<String, String> map;
    private HashMap<String, String> maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        final String userId = (String) SpUtils.getInstance().getData("userId", "");
        final String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
        cartPresenter = new CartPresenter(this);
        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maps = new HashMap<>();
                maps.put("userId",userId);
                maps.put("sessionId",sessionId);
                cartPresenter.cart(maps);
            }
        });
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", page);
        //Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        xiangPresenter = new XiangPresenter(this);
        map = new HashMap<>();
        map.put("commodityId", id + "");
        map.put("sessionId","sessionId");
        map.put("userId","userId");
        xiangPresenter.xiang(map);

    }

    @Override
    public void success(Object result) {
        xiangBean = (XiangBean) result;
        commodityId = xiangBean.getResult().getCommodityId();
        price.setText("￥:" + xiangBean.getResult().getPrice() + "元");
        kilo.setText("商品重量:"+xiangBean.getResult().getCommentNum() + "kg");
        count.setText(xiangBean.getResult().getCommodityName()+"");
        String[] split = xiangBean.getResult().getPicture().split(",");
        final List<String> image = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            image.add(split[i]);
        }
        xbander.setData(image, null);
        xbander.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(XiangActivity.this).load(image.get(position)).into((ImageView) view);
            }
        });
        String details = xiangBean.getResult().getDetails();

        WebSettings webSettings = wv.getSettings();
        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true);//缩放至屏幕大小

        webSettings.setSupportZoom(true);  //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置可以缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        webSettings.setDefaultFontSize(40);//设置 WebView 字体的大小，默认大小为 16
        webSettings.setMinimumFontSize(35);//设置 WebView 支持的最小字体大小，默认为 8

        webSettings.setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
        wv.loadData(details, "text/html", "UTF-8");//API提供的标准用法，无法解决乱码问题
        wv.loadData(details, "text/html; charset=UTF-8", null);//这种写法可以正确解码

    }

    @Override
    public void fail(Object msg) {

    }

    @Override
    public void onsuccess(Object result) {

        ChaBean chaBean = (ChaBean) result;
        for (ChaBean.ResultBean resultBean : chaBean.getResult()) {
            ShangpinBean shangpinBean  = new ShangpinBean(resultBean.getCount(),resultBean.getCommodityId());
            list.add(shangpinBean);
        }
        list.add(new ShangpinBean(1,commodityId));
        Gson gson = new Gson();
        String s = gson.toJson(list);
        tongPresenter = new TongPresenter(this);
        tongPresenter.tong(maps,s);
    }

    @Override
    public void onfail(Object msg) {

    }

    @Override
    public void tongsuccess(Object result) {
        TongBean tongBean = (TongBean) result;
        Toast.makeText(this, tongBean.getMessage()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void tongfail(Object msg) {

    }
}
