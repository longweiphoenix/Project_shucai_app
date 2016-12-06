package com.huangtao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/1.
 */
public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ItemData> list;
    LayoutInflater inflater;
    public ListAdapter(Context context, ArrayList<ItemData> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
        MyHondler myHondler;
        if (convertView == null) {
            myHondler = new MyHondler();
            convertView = inflater.inflate(R.layout.dare, null);
            myHondler.headImage = (ImageView) convertView.findViewById(R.id.imageview_tox);
            myHondler.name = (TextView) convertView.findViewById(R.id.textview_mz);
            myHondler.dynamicState = (TextView) convertView.findViewById(R.id.textview_dot);
            myHondler.fans = (TextView) convertView.findViewById(R.id.textview_fes);
            convertView.setTag(myHondler);
        } else {
            myHondler = (MyHondler) convertView.getTag();
        }
        ItemData itemData = list.get(position);
        myHondler.headImage.setImageResource(itemData.getImage());
        myHondler.name.setText(itemData.getName());
        myHondler.dynamicState.setText(itemData.getDynamicState() + "动态");
        myHondler.fans.setText(itemData.getFans() + "粉丝");

        return convertView;
    }

    class MyHondler{
        ImageView headImage;
        TextView name;
        TextView dynamicState;
        TextView fans;
    }

}
