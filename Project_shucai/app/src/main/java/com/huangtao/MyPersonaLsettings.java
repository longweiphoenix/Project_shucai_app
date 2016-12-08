package com.huangtao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.BaseActivity;
import com.example.along.ui1project.R;
import com.example.first.project.LoginPageActivity;
import com.example.zxy.AboutUsActivity;
import com.example.zxy.AdviceActivity;
import com.example.zxy.ImageSettingActivity;

/**
 * Created by Administrator on 2016/12/6.
 */
public class MyPersonaLsettings extends BaseActivity {
    ImageButton imageButton;
                 //图片质量 //清除缓存 //意见反馈 //有关我们 //支持我们 //退出账号
    LinearLayout picture,clear,advice,aboutus,support,bye;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalsettings_ht);
        imageButton= (ImageButton) findViewById(R.id.gersezfah);
        imageButton.setOnClickListener(onClickListener);
        picture= (LinearLayout) findViewById(R.id.picture_linearlayout);
        clear= (LinearLayout) findViewById(R.id.clear_linearlayout);
        advice= (LinearLayout) findViewById(R.id.advice_linearlayout);
        aboutus= (LinearLayout) findViewById(R.id.aboutus_linearlayout);
        support= (LinearLayout) findViewById(R.id.support_linearlayout);
        bye= (LinearLayout) findViewById(R.id.bye_linearlayout);
        picture.setOnClickListener(listener);
        advice.setOnClickListener(listener);
        aboutus.setOnClickListener(listener);
        bye.setOnClickListener(listener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.gersezfah:
                    finish();
                    break;
            }
        }
    };
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.picture_linearlayout:
                    Intent intent=new Intent(MyPersonaLsettings.this, ImageSettingActivity.class);
                    startActivity(intent);
                    break;
                case R.id.advice_linearlayout:
                    Intent intent1=new Intent(MyPersonaLsettings.this, AdviceActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.aboutus_linearlayout:
                    Intent intent2=new Intent(MyPersonaLsettings.this, AboutUsActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.bye_linearlayout:
                    Intent intent3 = new Intent(MyPersonaLsettings.this, LoginPageActivity.class);
                    startActivity(intent3);
            }
        }
    };
}
