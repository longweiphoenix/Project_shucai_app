package com.huangtao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class MyJieko extends BaseAdapter {
    Context context;
    List<HashMap<String,Object>> list;
    String[] from;
    int[] to;
    int resouceId;

    public MyJieko(Context context,List<HashMap<String,Object>> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(resouceId,null);
        HashMap<String,Object>map=list.get(position);
        for (int i=0;i<to.length;i++){
            int subViewId=to[i];
            View subView=view.findViewById(subViewId);
            if (subView instanceof TextView){
                TextView textView=(TextView)subView;
                String key=from[i];
                String str=map.get(key).toString();
                textView.setText(str);
            }
            if (subView instanceof ImageView){
                ImageView imageView=(ImageView)subView;
                String key=from[i];
                int imageId=(Integer)map.get(key);
                imageView.setImageResource(imageId);
            }
        }
        return view;
    }
}
