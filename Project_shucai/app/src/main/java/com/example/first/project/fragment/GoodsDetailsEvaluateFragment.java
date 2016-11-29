package com.example.first.project.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.needdata.GoodsComment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/0012.
 */

public class GoodsDetailsEvaluateFragment extends Fragment {

    LinearLayout linearLayout;
    ArrayList<GoodsComment> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_details_evaluate,null);

        linearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);
        getData();
        for (int i=0; i < list.size();i++){
            View view1 = inflater.inflate(R.layout.goods_details_evaluate_item,null);
            GoodsComment goodsComment = list.get(i);
            ImageView image = (ImageView) view1.findViewById(R.id.head_image);
            TextView userName = (TextView) view1.findViewById(R.id.user_name);
            TextView commentTime = (TextView) view1.findViewById(R.id.comment_time);
            TextView commentContent = (TextView) view1.findViewById(R.id.comment_content);

            image.setImageResource(goodsComment.getImage());
            userName.setText(goodsComment.getUserName());
            commentTime.setText(goodsComment.getCommentTime());
            commentContent.setText(goodsComment.getCommentContent());


            linearLayout.addView(view1);

        }
        return view;
    }

    public void getData(){
        list = new ArrayList<GoodsComment>();

        GoodsComment goodsComment = new GoodsComment();
        goodsComment.setImage(R.mipmap.avatar1);
        goodsComment.setUserName("小黄鸡");
        goodsComment.setCommentTime("昨天 09:23");
        goodsComment.setCommentContent("鸡蛋昨天才吃，味道确实不错");
        list.add(goodsComment);

        GoodsComment goodsComment1 = new GoodsComment();
        goodsComment1.setImage(R.mipmap.avatar2);
        goodsComment1.setUserName("偷吃鱼");
        goodsComment1.setCommentTime("9月 23日 11:23");
        goodsComment1.setCommentContent("鸡蛋昨天才吃，味道确实不错");
        list.add(goodsComment1);

        GoodsComment goodsComment12 = new GoodsComment();
        goodsComment12.setImage(R.mipmap.avatar3);
        goodsComment12.setUserName("小黄鸡");
        goodsComment12.setCommentTime("昨天 09:23");
        goodsComment12.setCommentContent("鸡蛋昨天才吃，味道确实不错");
        list.add(goodsComment12);

        GoodsComment goodsComment3 = new GoodsComment();
        goodsComment3.setImage(R.mipmap.avatar4);
        goodsComment3.setUserName("小黄鸡");
        goodsComment3.setCommentTime("昨天 09:23");
        goodsComment3.setCommentContent("鸡蛋昨天才吃，味道确实不错");
        list.add(goodsComment3);


    }

}
