package com.example.classtwo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/8.
 */

public class WhoAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    //用来放数据
    public ArrayList<String> data  =  new ArrayList<String>();


    //当创建viewHolder的时候调用
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //因为要返回的是viewHolder  所以需要建立一个内部类viewHolder
        //首先加载布局
        //把xml变成一个view

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_who,parent,false
        );

        return new ViewHolder(view);
    }

    //绑定viewHolder的时候调用 ： 设置数据 ， 就需要为viewHolder设置内容
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //向下转型
        //首先 找到text_View   然后再找到内容(data.get(position)) ，最后再setText ；
        ((ViewHolder)holder).text_View.setText(data.get(position));
    }

    //获取item的个数 -> 由ArrayList 的长度来决定
    @Override
    public int getItemCount() {
        return data.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView text_View ;
        /*
               用来放数字
               假设每个ViewHolder已经把Item_who.xml加载上去了
               itemView  代表了刚刚写的  item_who.xml
         */
        public ViewHolder(View itemView) {
            super(itemView);
            //找到Text_View ；
            text_View = (TextView) itemView.findViewById(R.id.text_view) ;
        }

    }

}
