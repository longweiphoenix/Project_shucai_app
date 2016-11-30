package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.along.ui1project.PersonalSettingActivity;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/20.
 */
public class ImageSetting extends Activity{
    ImageView imageSettingArowImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_setting);
        imageSettingArowImageView= (ImageView) findViewById(R.id.image_setting_arow);
        imageSettingArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageSetting.this, PersonalSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
