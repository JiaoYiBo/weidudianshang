package com.example.aason.weidudianshang.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.PinBean;
import com.example.aason.weidudianshang.bean.WanBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WanAdapter extends XRecyclerView.Adapter<WanAdapter.MyVh> {
    private Context context;
    private List<WanBean.ResultBean>list;

    public WanAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<WanBean.ResultBean>list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.eitem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, final int i) {
        myVh.img.setImageURI(list.get(i).getMasterPic());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.dindan.setText(list.get(i).getPrice()+"");
        myVh.popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                list.remove(i);
                notifyDataSetChanged();
                Toast.makeText(context, "删除订单成功", Toast.LENGTH_SHORT).show();
                builder.show();
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
        private final TextView popup;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);
            dindan = itemView.findViewById(R.id.text_frag04_orderfrag02_addNum);
            popup = itemView.findViewById(R.id.popup);

        }
    }
}
