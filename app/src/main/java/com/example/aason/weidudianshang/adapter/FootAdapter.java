package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.FootBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FootAdapter extends RecyclerView.Adapter<FootAdapter.MyVh> {
    private Context context;
    private List<FootBean.ResultBean> list;

    public FootAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<FootBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pubuliu,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
            myVh.title.setText(list.get(i).getCommodityName());
        Glide.with(context).load(list.get(i).getMasterPic()).into(myVh.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView img;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
                img = itemView.findViewById(R.id.img);
        }
    }
}
