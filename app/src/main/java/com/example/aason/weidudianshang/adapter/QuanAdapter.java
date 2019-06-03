package com.example.aason.weidudianshang.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aason.weidudianshang.R;
import com.example.aason.weidudianshang.bean.QuanBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuanAdapter extends XRecyclerView.Adapter<QuanAdapter.MyVh> {
    private Context context;
    private List<QuanBean.ResultBean>list;
    private QuanBean quanBean;
    public QuanAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<QuanBean.ResultBean> list) {
        this.list.clear();
        this.list.addAll(list);
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuanAdapter.MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.quanitem,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuanAdapter.MyVh myVh, final int i) {
        myVh.img.setImageURI(list.get(i).getHeadPic());
        myVh.img1.setImageURI(list.get(i).getImage());
        myVh.img2.setImageURI(list.get(i).getImage());
        myVh.name.setText(list.get(i).getNickName());
        myVh.title.setText(list.get(i).getContent());
        myVh.count.setText(list.get(i).getGreatNum()+"");
        myVh.cks.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int ss = list.get(i).getGreatNum();
                if (isChecked)
                {
                    ss++;
                    myVh.count.setText(ss+"");
                    Toast.makeText(context,"点赞成功",Toast.LENGTH_LONG).show();
                }else{
                    myVh.count.setText(ss+"");
                    Toast.makeText(context,"取消点赞",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img,img1,img2;
        private final TextView name,title;
        private final TextView count;
        private final CheckBox cks;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            count = itemView.findViewById(R.id.count);
            cks = itemView.findViewById(R.id.cks);
        }
    }
}
