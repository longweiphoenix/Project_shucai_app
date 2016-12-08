package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.BaseActivity;
import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.PersonalInfoActivity;
import com.example.along.ui1project.R;
import com.huangtao.MyPersonaLsettings;

/**
 * Created by Administrator on 2016/10/20.
 */
public class AboutUsActivity extends BaseActivity {
    ImageView aboutUsImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        aboutUsImageView= (ImageView) findViewById(R.id.aboutus_arow);
        aboutUsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this, MyPersonaLsettings.class);
                startActivity(intent);
            }
        });
    }
}
