package com.example.aason.weidudianshang.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.DingBean;
import com.example.aason.weidudianshang.bean.ShouBean;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShouAdapter extends XRecyclerView.Adapter<ShouAdapter.MyVh> {
    private Context context;
    private List<ShouBean.ResultBean.MlssBean.CommodityListBeanXX>list;

    public ShouAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<ShouBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.citem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, final int i) {
        myVh.img.setImageURI(list.get(i).getMasterPic());
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
        myVh.dindan.setText(list.get(i).getPrice()+"");
        myVh.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    list.remove(i);
                    notifyDataSetChanged();
                Toast.makeText(context, "收货成功", Toast.LENGTH_SHORT).show();
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
        private final Button btn2;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);
            btn2 = itemView.findViewById(R.id.btn2);
            dindan = itemView.findViewById(R.id.text_frag04_orderfrag02_addNum);


        }
    }
}
