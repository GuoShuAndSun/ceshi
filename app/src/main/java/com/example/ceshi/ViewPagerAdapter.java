package com.example.ceshi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    public List<String> titles=new ArrayList<>();

    public List<Integer> colors=new ArrayList<>();


    public ViewPagerAdapter(){
        titles.add("首页");
        titles.add("分类");
        titles.add("课程");
        titles.add("书籍");
        titles.add("星图");

        colors.add(R.color.red1);
        colors.add(R.color.red2);
        colors.add(R.color.red3);
        colors.add(R.color.red4);
        colors.add(R.color.red5);


    }

    //绑定布局
    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_pager,parent,false));
    }
    //绑定数据和颜色
    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {

        //绑定title的名字和
        //绑定每个viewPager的背景的颜色
        holder.myTv.setText(titles.get(position));
        holder.mycontainer.setBackgroundResource(colors.get(position));


    }
    //返回viewPager的界面数
    @Override
    public int getItemCount() {
        return 5;
    }

    //定义内部类做类的泛型拓展
    //用于解析item_pager
    class ViewPagerViewHolder extends RecyclerView.ViewHolder{

        TextView myTv;
        RelativeLayout mycontainer;


        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mycontainer=itemView.findViewById(R.id.mycontainer);
            myTv=itemView.findViewById(R.id.tvtitle);

        }
    }
}
