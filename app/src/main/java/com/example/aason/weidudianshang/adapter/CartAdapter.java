package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.CartBean;
import com.example.aason.weidudianshang.bean.ChaBean;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.example.aason.weidudianshang.callback.CartCallback;
import com.example.aason.weidudianshang.view.AddMinusView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends XRecyclerView.Adapter<CartAdapter.MyVh> {
    private Context context;
    private List<ChaBean.ResultBean>list;
    private CartCallback cartCallBack;

    public void setCartCallBack(CartCallback cartCallBack) {
        if(cartCallBack != null){
            this.cartCallBack = cartCallBack;
        }
        notifyDataSetChanged();
    }
    public CartAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<ChaBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartAdapter.MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cartitem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.MyVh myVh, final int i) {
        final ChaBean.ResultBean resultBean = list.get(i);
        myVh.img.setImageURI(list.get(i).getPic());
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
        myVh.cks.setChecked(list.get(i).isChecked);
        myVh.cks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(i).isChecked= myVh.cks.isChecked();
                notifyDataSetChanged();
                boolean checked = true;
                for(ChaBean.ResultBean resultBean1 : list){
                    if(!resultBean1.isChecked){
                        checked = false;
                    }
                    if(cartCallBack != null){
                        cartCallBack.notifyCartItem(checked);
                    }
                }
                if(cartCallBack != null){
                    cartCallBack.notifyNum();
                }
            }
        });
        myVh.addMinusView.setAddMinusCallback(new AddMinusView.AddMinusCallback() {
            @Override
            public void numCallback(int num) {
                resultBean.productNum=num;
                if (cartCallBack != null) {
                    cartCallBack.notifyNum();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView title;
        private final TextView price;
        private final CheckBox cks;
        private AddMinusView addMinusView;
        public MyVh(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            cks = itemView.findViewById(R.id.cks);
            addMinusView = itemView.findViewById(R.id.addminusView);
        }
    }
}
