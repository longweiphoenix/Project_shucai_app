package com.example.along.ui1project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Long on 2016/11/9.
 */
public class ShopShowAdapter extends BaseAdapter {
    List<ShopItem> list;
    int resourceId;
    Context context;
    LayoutInflater inflater;
    public ShopShowAdapter(List<ShopItem> list,int resourceId, Context context,LayoutInflater inflater){
        this.list=list;
        this.resourceId=resourceId;
        this.context=context;
        this.inflater=inflater;
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
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(resourceId,null);
            viewHolder.img= (ImageView) convertView.findViewById(R.id.img);
            viewHolder.title= (TextView) convertView.findViewById(R.id.vegetable_title);
            viewHolder.subtitle= (TextView) convertView.findViewById(R.id.vegetable_subtitle);
            viewHolder.price= (TextView) convertView.findViewById(R.id.price);
            viewHolder.unit= (TextView) convertView.findViewById(R.id.unit);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        ShopItem item=list.get(position);
        viewHolder.img.setImageResource(item.getImg());
        viewHolder.title.setText(item.getTitle());
        viewHolder.subtitle.setText(item.getSubTitle());
        viewHolder.price.setText("￥"+item.getPrice());
        viewHolder.unit.setText(item.getUnit());
        return convertView;
    }
    private class ViewHolder {
        ImageView img;
        TextView title,subtitle,price,unit;
    }
}
