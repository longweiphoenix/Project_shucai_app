package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.PersonalInfoActivity;
import com.example.along.ui1project.R;
import com.example.zxy.http.NameAccount;

import java.net.MalformedURLException;

/**
 * Created by Administrator on 2016/10/23.
 */
public class NameSettingActivity extends Activity {
    ImageView nameSettingArowImageView;//返回
    TextView nameCommit;
    EditText name;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_setting);
        name= (EditText) findViewById(R.id.name_setting_textview);
        nameCommit= (TextView) findViewById(R.id.name_setting_commit);
        nameSettingArowImageView = (ImageView) findViewById(R.id.name_setting_arow);
        nameSettingArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NameSettingActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
        nameCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NameSettingActivity.this,"修改成功！",Toast.LENGTH_LONG).show();
            }
        });
    }
    /*public void commit(){
        try {
         *//*   NameAccount nameAccount=new NameAccount(name.getText().toString().trim());*//*

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }*/
}
