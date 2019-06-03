package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.AddressBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends XRecyclerView.Adapter<AddressAdapter.MyVh> {
    private Context context;
    private List<AddressBean.ResultBean> list;

    public AddressAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<AddressBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.addressitem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        myVh.name.setText(list.get(i).getRealName());
        myVh.data.setText(list.get(i).getAddress());
        myVh.phone.setText(list.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView phone;
        private final TextView data;
        public MyVh(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            data = itemView.findViewById(R.id.data);
        }
    }
}
