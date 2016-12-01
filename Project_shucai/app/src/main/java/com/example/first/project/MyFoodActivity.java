package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/0010.
 */

public class MyFoodActivity extends Activity {
    ImageView back; //返回上级
    TextView rules; //粮票使用规则
    ImageView getFood; //获得粮票
    EditText favorable; //优惠码
    TextView exchange; //兑换
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_food);
        findView();

        rules.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);

    }
    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rules:
                    intent = new Intent(MyFoodActivity.this,FoodRulesActivity.class);
                    startActivity(intent);
                    break;
                case R.id.arow:
                    intent = new Intent(MyFoodActivity.this, MyHomePageActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


    public void findView(){
        back = (ImageView) findViewById(R.id.back);
        rules = (TextView) findViewById(R.id.rules);
        getFood = (ImageView) findViewById(R.id.get_food);
        favorable = (EditText) findViewById(R.id.favorable);
        exchange = (TextView) findViewById(R.id.exchange);
    }
}
