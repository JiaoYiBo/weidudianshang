package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.adapter.AddressAdapter;
import com.example.aason.weidudianshang.bean.AddressBean;
import com.example.aason.weidudianshang.contract.AddressContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.RessPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

public class AddressActivity extends AppCompatActivity implements AddressContract.IRessView {

    private XRecyclerView rev;
    private RessPresenter ressPresenter;
    private AddressAdapter addresAdapter;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        rev = findViewById(R.id.rev);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.textView_myMessage_perfect);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        rev.setLayoutManager(new LinearLayoutManager(this));
        ressPresenter = new RessPresenter(this);
        String userId = (String) SpUtils.getInstance().getData("userId", "");
        String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
        HashMap<String, String> map = new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",userId);
        ressPresenter.ress(map);


    }

    @Override
    public void success(Object result) {
        AddressBean addressBean = (AddressBean) result;
        List<AddressBean.ResultBean> result1 = addressBean.getResult();
        addresAdapter = new AddressAdapter(this);
        rev.setAdapter(addresAdapter);
        addresAdapter.setList(result1);

    }

    @Override
    public void fail(Object msg) {

    }
}
