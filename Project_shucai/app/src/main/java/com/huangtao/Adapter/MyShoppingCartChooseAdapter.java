package com.huangtao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.huangtao.MyShoppingcartchoose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */

public class MyShoppingCartChooseAdapter extends BaseAdapter {
    Context context;
    List<HashMap<String, Object>> list;
    LayoutInflater layoutInflater;

    //设置构造器
    public MyShoppingCartChooseAdapter(Context context, List<HashMap<String, Object>> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.activity_shoppingcart_ht, null);
            viewHolder.productImage = (ImageView) convertView.findViewById(R.id.product_image);
            viewHolder.productName = (TextView) convertView.findViewById(R.id.product_name);
            viewHolder.productIntroduce = (TextView) convertView.findViewById(R.id.product_introduce);
            viewHolder.productPrice = (TextView) convertView.findViewById(R.id.product_price);
            viewHolder.shoppingcart_delete = (ImageView) convertView.findViewById(R.id.shoppingcart_delete);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        HashMap<String, Object> map = list.get(position);
        viewHolder.productImage.setImageResource((Integer) map.get("productImage"));
        viewHolder.productName.setText(map.get("productName").toString());
        viewHolder.productIntroduce.setText(map.get("productIntroduce").toString());
        viewHolder.productPrice.setText(map.get("productPrice").toString());
        if ((map.get("booleanDelete") != null) && Boolean.parseBoolean(map.get("booleanDelete").toString())) {
            viewHolder.shoppingcart_delete.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    //复用

    class ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productIntroduce;
        TextView productPrice;
        ImageView shoppingcart_delete;
    }

}