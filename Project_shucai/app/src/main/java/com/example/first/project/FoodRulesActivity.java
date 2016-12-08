package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.BaseActivity;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/0010.
 */

public class FoodRulesActivity extends BaseActivity {
    ImageView imageView;  //返回上级
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_rules);

        imageView = (ImageView) findViewById(R.id.back);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
