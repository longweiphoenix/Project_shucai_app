package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.PersonalInfo;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/23.
 */
public class NameSetting extends Activity {
    ImageView nameSettingArowImageView;//返回
    TextView nameCommit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_setting);
        nameCommit= (TextView) findViewById(R.id.name_setting_commit);
        nameSettingArowImageView = (ImageView) findViewById(R.id.name_setting_arow);
        nameSettingArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NameSetting.this, PersonalInfo.class);
                startActivity(intent);
            }
        });
        nameCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NameSetting.this,"修改成功！",Toast.LENGTH_LONG).show();
            }
        });
    }
}
