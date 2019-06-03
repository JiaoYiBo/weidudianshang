package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.avtivity.PinjiaActivity;
import com.example.aason.weidudianshang.bean.PageBean;
import com.example.aason.weidudianshang.bean.PinBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PinAdapter extends XRecyclerView.Adapter<PinAdapter.MyVh> {
    private Context context;
    private List<PinBean.ResultBean>list;

    public PinAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<PinBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.ditem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        myVh.img.setImageURI(list.get(i).getMasterPic());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.dindan.setText(list.get(i).getPrice()+"");
        myVh.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PinjiaActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final TextView title,price;
        private final SimpleDraweeView img;
        private final TextView dindan;
        private final Button btn;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            btn = itemView.findViewById(R.id.btn);
            img = itemView.findViewById(R.id.img);
            dindan = itemView.findViewById(R.id.text_frag04_orderfrag02_addNum);

        }
    }
}
