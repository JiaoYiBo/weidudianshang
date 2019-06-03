package com.example.aason.weidudianshang.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.avtivity.PageActivity;
import com.example.aason.weidudianshang.bean.DingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DingAdapter extends XRecyclerView.Adapter<DingAdapter.MyVh> {
    private Context context;
    private List<DingBean.ResultBean.RxxpBean.CommodityListBean>list;

    public DingAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<DingBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.aitem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, final int i) {
        myVh.img.setImageURI(list.get(i).getMasterPic());
        myVh.img1.setImageURI(list.get(i).getMasterPic());
        myVh.price.setText("￥:"+list.get(i).getPrice()+"");
        myVh.price1.setText("￥:"+list.get(i).getPrice()+"");
        myVh.title.setText(list.get(i).getCommodityName());
        myVh.title1.setText(list.get(i).getCommodityName());
        myVh.dindan.setText(list.get(i).getPrice()+"");
        myVh.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PageActivity.class);
                context.startActivity(intent);
            }
        });
       myVh.btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(context);
               builder.setTitle("取消订单");
               builder.setMessage("你确定要取消订单吗?");
               builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       list.remove(i);
                       notifyDataSetChanged();
                       Toast.makeText(context,"取消成功",Toast.LENGTH_SHORT).show();
                   }
               });
               builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(context,"取消成功",Toast.LENGTH_SHORT).show();
                   }
               });
               builder.show();
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final TextView title,title1,price,price1;
        private final SimpleDraweeView img,img1;
        private final TextView dindan;
        private final Button btn2,btn1;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            title1 = itemView.findViewById(R.id.title1);
            price = itemView.findViewById(R.id.price);
            price1 = itemView.findViewById(R.id.price1);
            img = itemView.findViewById(R.id.img);
            img1 = itemView.findViewById(R.id.img1);
            dindan = itemView.findViewById(R.id.text_frag04_orderfrag02_addNum);
            btn2 = itemView.findViewById(R.id.btn2);
            btn1 = itemView.findViewById(R.id.btn1);


        }
    }
}
