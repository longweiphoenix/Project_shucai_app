package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.along.ui1project.MyHomePage;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/0011.
 */

public class OrganicLifeActivity extends Activity {

    ImageView back; //返回上级
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organic_life);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrganicLifeActivity.this, MyHomePage.class);
                startActivity(intent);
            }
        });
    }

}
