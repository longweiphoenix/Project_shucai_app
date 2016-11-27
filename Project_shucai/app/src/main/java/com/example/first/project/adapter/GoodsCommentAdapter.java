package com.example.first.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.needdata.GoodsComment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/0027.
 */

public class GoodsCommentAdapter extends BaseAdapter {
    Context context;
    ArrayList<GoodsComment> list;
    LayoutInflater inflater;

    public GoodsCommentAdapter( Context context,ArrayList<GoodsComment> list){
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
        Hondler hondler = null;
        if (convertView == null){
            hondler = new Hondler();
            convertView = inflater.inflate(R.layout.goods_details_evaluate_item,null);
            hondler.headImage = (ImageView) convertView.findViewById(R.id.head_image);
            hondler.userName = (TextView) convertView.findViewById(R.id.user_name);
            hondler.commentTime = (TextView) convertView.findViewById(R.id.comment_time);
            hondler.commentContent = (TextView) convertView.findViewById(R.id.comment_content);
            convertView.setTag(hondler);
        }else {
            hondler = (Hondler) convertView.getTag();
        }
        GoodsComment goodsComment = list.get(position);
        hondler.headImage.setImageResource(goodsComment.getImage());
        hondler.userName.setText(goodsComment.getUserName());
        hondler.commentTime.setText(goodsComment.getCommentTime());
        hondler.commentContent.setText(goodsComment.getCommentContent());

        return convertView;
    }

    class Hondler{
        ImageView headImage;
        TextView userName;
        TextView commentTime;
        TextView commentContent;
    }
}
