package com.example.first.project;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.fragment.GoodsDetailsEvaluateFragment;
import com.example.first.project.fragment.GoodsDetailsFragment;

/**
 * Created by Administrator on 2016/11/0012.
 */

public class GoodsDetailsActivity extends Activity {
    LinearLayout linearLayout; //添加fragment(评论与详情)
    TextView details; //商品详情
    ImageView left; //详情下边的横线
    TextView evaluate; //商品评价
    ImageView right; //评价下边的横线

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_details);

        findView();
        createFragment();

        details.setOnClickListener(onClickListener);
        evaluate.setOnClickListener(onClickListener);


    }
    GoodsDetailsEvaluateFragment goodsDetailsEvaluateFragment;
    GoodsDetailsFragment goodsDetailsFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    //创建fragment管理器对象
    public void createFragment(){
        goodsDetailsFragment = new GoodsDetailsFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.linearlayout,goodsDetailsFragment);
        fragmentTransaction.commit();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goods_details:
                    left.setVisibility(View.VISIBLE);
                    right.setVisibility(View.INVISIBLE);


                    break;
                case R.id.goods_evaluater:
                    left.setVisibility(View.INVISIBLE);
                    right.setVisibility(View.VISIBLE);

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
    }
}
