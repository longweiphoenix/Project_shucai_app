package com.example.zxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.along.ui1project.MyHomePage;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/30.
 */
public class HealthyMenuOne extends Activity {
    Button menuButton;
    ImageView menuArowImageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_one);
        menuButton= (Button) findViewById(R.id.menu_button);
        menuArowImageView= (ImageView) findViewById(R.id.menu_arow_imageview);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HealthyMenuOne.this,Cooking.class);
                startActivity(intent);
            }
        });
        menuArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthyMenuOne.this, MyHomePage.class);
                startActivity(intent);
            }
        });
    }
}
