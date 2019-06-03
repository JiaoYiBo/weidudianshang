package com.example.aason.weidudianshang.avtivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.AddBean;
import com.example.aason.weidudianshang.contract.AddContract;
import com.example.aason.weidudianshang.net.SpUtils;
import com.example.aason.weidudianshang.presenter.AddPresenter;
import com.lljjcoder.citypickerview.widget.CityPicker;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddActivity extends AppCompatActivity implements AddContract.IAddView {
    @BindView(R.id.new_address_edit_name)
    EditText newAddressEditName;
    @BindView(R.id.new_address_edit_phone)
    EditText newAddressEditPhone;
    @BindView(R.id.new_address_edit_address)
    EditText newAddressEditAddress;
    @BindView(R.id.new_address_edit_zipCode)
    EditText newAddressEditZipCode;
    @BindView(R.id.new_address_image_open)
    ImageView newAddressImageOpen;
    @BindView(R.id.new_address_text_save)
    Button newAddressTextSave;
    private TextView new_address_text_city;
    private AddPresenter addPresenter;
    private HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_add_address);
        ButterKnife.bind(this);
        addPresenter = new AddPresenter(this);

        String userId = (String) SpUtils.getInstance().getData("userId", "");
        String sessionId = (String) SpUtils.getInstance().getData("sessionId", "");
        map = new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",userId);

        new_address_text_city = findViewById(R.id.new_address_text_city);

    }

    @OnClick({R.id.new_address_image_open, R.id.new_address_text_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.new_address_image_open:
                CityPicker cityPicker = new CityPicker.Builder(this)
                        .textSize(14)
                        .title("请选择所在地区")
                        .titleBackgroundColor("#FFFFFF")
                        .confirTextColor("#ff0000")
                        .cancelTextColor("#696969")
                        .province("北京市")
                        .city("北京市")
                        .district("昌平区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(false)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .onlyShowProvinceAndCity(false)
                        .build();
                cityPicker.show();
                //监听方法，获取选择结果
                cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
                    @Override
                    public void onSelected(String... citySelected) {
                        //省份
                        String province = citySelected[0];
                        //城市
                        String city = citySelected[1];
                        //区县（如果设定了两级联动，那么该项返回空）
                        String district = citySelected[2];
                        //邮编
                        String code = citySelected[3];
                        //为TextView赋值
                        new_address_text_city.setText(province + " " + city + " " + district + " ");
                    }
                });
                break;
            case R.id.new_address_text_save:
                String save_name = newAddressEditName.getText().toString().trim();
                String save_phone = newAddressEditPhone.getText().toString().trim();
                String save_city = new_address_text_city.getText().toString().trim();
                String save_add = newAddressEditAddress.getText().toString().trim();
                String save_zipCode = newAddressEditZipCode.getText().toString().trim();
                String city_add = save_city+","+save_add;
                //MyNewAddress myNewAddress = new MyNewAddress(save_city, save_add);
                //String save_address = new Gson().toJson(myNewAddress);
                HashMap<String, String> param = new HashMap<>();
                param.put("realName",save_name);
                param.put("phone",save_phone);
                param.put("address",city_add);
                param.put("zipCode",save_zipCode);
                addPresenter.adds(map,param);
                //进行数据请求

                break;
        }
    }

    @Override
    public void success(Object result) {
        AddBean addBean = (AddBean) result;
        if (addBean.getStatus().equals("0000")) {
            Intent intent = new Intent(AddActivity.this, AddressActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void fail(Object msg) {

    }
}
