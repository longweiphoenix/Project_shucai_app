package com.example.first.project;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.BaseActivity;
import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;
import com.example.along.ui1project.objects.ShopItem;
import com.example.first.project.fragment.GoodsDetailsEvaluateFragment;
import com.example.first.project.fragment.GoodsDetailsFragment;
import com.sina.weibo.sdk.api.share.Base;

/**
 * Created by Administrator on 2016/11/0012.
 */

public class GoodsDetailsActivity extends BaseActivity {
    LinearLayout linearLayout; //添加fragment(评论与详情)
    TextView details; //商品详情
    ImageView left; //详情下边的横线
    TextView evaluate; //商品评价
    ImageView right; //评价下边的横线
    ImageView arow; //返回
    TextView ser; //客服
    ShopItem item;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_details);

        if(getIntent().hasExtra("item")) {
            item = (ShopItem) getIntent().getSerializableExtra("item");
        }

        //item.getImg();

        findView();
        imageView.setImageResource(item.getImg());
        createFragment();

        details.setOnClickListener(onClickListener);
        evaluate.setOnClickListener(onClickListener);
        arow.setOnClickListener(onClickListener);
        ser.setOnClickListener(onClickListener);

    }

    GoodsDetailsEvaluateFragment goodsDetailsEvaluateFragment; //评论
    GoodsDetailsFragment goodsDetailsFragment; //详情

    FragmentManager fragmentManager;

    //创建fragment管理器对象
    public void createFragment(){
        goodsDetailsFragment = new GoodsDetailsFragment();
        goodsDetailsEvaluateFragment = new GoodsDetailsEvaluateFragment();
        fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().add(R.id.linearlayout,goodsDetailsFragment).commit();
        fragmentManager.beginTransaction().add(R.id.linearlayout,goodsDetailsEvaluateFragment).commit();
        fragmentManager.beginTransaction().hide(goodsDetailsEvaluateFragment).commit();
    }

    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goods_details:
                    left.setVisibility(View.VISIBLE);
                    right.setVisibility(View.INVISIBLE);

                    fragmentManager.beginTransaction().show(goodsDetailsFragment).commit();
                    fragmentManager.beginTransaction().hide(goodsDetailsEvaluateFragment).commit();

                    break;
                case R.id.goods_evaluater:
                    left.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.VISIBLE);
                    fragmentManager.beginTransaction().show(goodsDetailsEvaluateFragment).commit();
                    fragmentManager.beginTransaction().hide(goodsDetailsFragment).commit();
                    break;
                case R.id.arow:
                    finish();
                    break;
                case R.id.service:
                    intent = new Intent(GoodsDetailsActivity.this,CustomerServiceActivity.class); //跳转到客服
                    startActivity(intent);
                    break;
            }

        }
    };


    public void findView(){
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        details = (TextView) findViewById(R.id.goods_details);
        left = (ImageView) findViewById(R.id.left);
        evaluate = (TextView) findViewById(R.id.goods_evaluater);
        right = (ImageView) findViewById(R.id.right);
        arow = (ImageView) findViewById(R.id.arow);
        ser = (TextView) findViewById(R.id.service);
        imageView = (ImageView) findViewById(R.id.title_image);
    }
}
