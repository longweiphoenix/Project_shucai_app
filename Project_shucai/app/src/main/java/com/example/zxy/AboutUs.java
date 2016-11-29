package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.along.ui1project.MyHomePage;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/20.
 */
public class AboutUs extends Activity {
    ImageView aboutUsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        aboutUsImageView= (ImageView) findViewById(R.id.aboutus_arow);
        aboutUsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUs.this, MyHomePage.class);
            }
        });
    }
}
