package com.example.zxy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */

public class CookingProcessAdapter extends BaseAdapter {
    Context context;
    List<HashMap<String,Object>> newList;
    LayoutInflater layoutInflater;
    public CookingProcessAdapter(Context context, List<HashMap<String,Object>> newList){
        this.context=context;
        this.newList=newList;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return newList.size();
    }

    @Override
    public Object getItem(int position) {
        return newList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.listview_menu_process_layout,null);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.menu_process_imageview);
            viewHolder.number= (TextView) convertView.findViewById(R.id.number);
            viewHolder.process= (TextView) convertView.findViewById(R.id.menu_process);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        HashMap<String,Object> map = newList.get(position);
        viewHolder.imageView.setImageResource((Integer) map.get("image"));
        viewHolder.number.setText(map.get("number").toString());
        viewHolder.process.setText(map.get("process").toString());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView number;
        TextView process;
    }
}
