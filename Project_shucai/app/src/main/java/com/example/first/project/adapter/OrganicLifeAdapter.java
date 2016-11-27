package com.example.first.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.needdata.OrganicLife;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/0027.
 */

public class OrganicLifeAdapter extends BaseAdapter {
    Context context;
    ArrayList<OrganicLife> lifes;

    LayoutInflater inflater;

    public OrganicLifeAdapter( Context context, ArrayList<OrganicLife> lifes){
        this.context = context;
        this.lifes = lifes;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lifes.size();
    }

    @Override
    public Object getItem(int position) {
        return lifes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hondler hondler = null;
        if (convertView == null){
            hondler = new Hondler();
            convertView = inflater.inflate(R.layout.organic_life_item,null);
            hondler.title = (TextView) convertView.findViewById(R.id.title);
            hondler.image = (ImageView) convertView.findViewById(R.id.image);
            hondler.loveNumb = (TextView) convertView.findViewById(R.id.love_numb);
            hondler.seeNumb = (TextView) convertView.findViewById(R.id.see_numb);
            convertView.setTag(hondler);
        }else {
            hondler = (Hondler) convertView.getTag();
        }

        OrganicLife organicLife = lifes.get(position);
        hondler.title.setText(organicLife.getTitle());
        hondler.image.setImageResource(organicLife.getImage());
        hondler.loveNumb.setText(organicLife.getLoveNumb().toString());
        hondler.seeNumb.setText(organicLife.getSeeNumb().toString());

        return convertView;
    }

    class Hondler{
        TextView title;
        ImageView image;
        TextView loveNumb;
        TextView seeNumb;
    }
}
