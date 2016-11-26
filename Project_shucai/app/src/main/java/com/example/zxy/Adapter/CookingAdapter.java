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

public class CookingAdapter extends BaseAdapter {
    Context context;
    List<HashMap<String,Object>> list;
    LayoutInflater layoutInflater;
    public int getCount() {
        return list.size();
    }
    public CookingAdapter(Context context, List<HashMap<String,Object>> list){
        this.list = list;
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
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
            convertView=layoutInflater.inflate(R.layout.listview_menu_parepre_layout,null);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.menu_parepre_image);
            viewHolder.parepreOne= (TextView) convertView.findViewById(R.id.menu_parepre_material_1);
            viewHolder.parepreTwo= (TextView) convertView.findViewById(R.id.menu_parepre_material_2);
            viewHolder.parepreThree= (TextView) convertView.findViewById(R.id.menu_parepre_material_3);
            viewHolder.parepreFour= (TextView) convertView.findViewById(R.id.menu_parepre_material_4);
            viewHolder.parepreFive= (TextView) convertView.findViewById(R.id.menu_parepre_material_5);
            viewHolder.weightOne= (TextView) convertView.findViewById(R.id.menu_parepre_weight_1);
            viewHolder.weightTwo= (TextView) convertView.findViewById(R.id.menu_parepre_weight_2);
            viewHolder.weightThree= (TextView) convertView.findViewById(R.id.menu_parepre_weight_3);
            viewHolder.weightFour= (TextView) convertView.findViewById(R.id.menu_parepre_weight_4);
            viewHolder.weightFive= (TextView) convertView.findViewById(R.id.menu_parepre_weight_5);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        HashMap<String,Object> map =list.get(position);
        viewHolder.imageView.setImageResource((Integer) map.get("image"));
        viewHolder.parepreOne.setText(map.get("parepreOne").toString());
        viewHolder.parepreTwo.setText(map.get("parepreTwo").toString());
        viewHolder.parepreThree.setText(map.get("parepreThree").toString());
        viewHolder.parepreFour.setText(map.get("parepreFour").toString());
        viewHolder.parepreFive.setText(map.get("parepreFive").toString());
        viewHolder.weightOne.setText(map.get("weightOne").toString());
        viewHolder.weightTwo.setText(map.get("weightTwo").toString());
        viewHolder.weightThree.setText(map.get("weightThree").toString());
        viewHolder.weightFour.setText(map.get("weightFour").toString());
        viewHolder.weightFive.setText(map.get("weightFive").toString());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView parepreOne;
        TextView parepreTwo;
        TextView parepreThree;
        TextView parepreFour;
        TextView parepreFive;
        TextView weightOne;
        TextView weightTwo;
        TextView weightThree;
        TextView weightFour;
        TextView weightFive;
    }
}
