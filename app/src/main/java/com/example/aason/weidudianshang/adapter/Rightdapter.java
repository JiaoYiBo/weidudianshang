package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.ShowBean;
import com.example.aason.weidudianshang.bean.UserBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


public class Rightdapter extends BaseAdapter {
    private Context context;
    private List<UserBean.ResultBean> list;

    public Rightdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<UserBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context,R.layout.moli,null);
            holder = new ViewHolder();
            holder.img  = convertView.findViewById(R.id.img);
            holder.title =convertView.findViewById(R.id.title);
            holder.price = convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else{
            holder  = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageURI(list.get(position).getMasterPic());
        holder.title.setText(list.get(position).getCommodityName());
        holder.price.setText(list.get(position).getPrice()+"");
        return convertView;
    }
    public class ViewHolder{
        SimpleDraweeView img;
        TextView title,price;
    }
}
