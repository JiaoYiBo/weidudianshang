package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.HotBean;
import com.example.aason.weidudianshang.bean.ShouBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotAdapter extends XRecyclerView.Adapter<HotAdapter.MyVh> {
    private Context context;
    private List<HotBean.ResultBean>list;

    public HotAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<HotBean.ResultBean>list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.moli,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        myVh.img.setImageURI(list.get(i).getMasterPic());
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final TextView title,price;
        private final SimpleDraweeView img;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);


        }
    }
}
