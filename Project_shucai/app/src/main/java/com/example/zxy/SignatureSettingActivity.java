package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BaseActivity;
import com.example.along.ui1project.PersonalInfoActivity;
import com.example.along.ui1project.R;
import com.example.first.project.application.DataApplication;
import com.example.zxy.http.NameAccount;
import com.example.zxy.http.SignatureAccount;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;

/**
 * Created by Administrator on 2016/10/23.
 */
public class SignatureSettingActivity extends BaseActivity {
    TextView signatureCommit;//提交
    ImageView signatureArow;//返回
    EditText signature;//输入框
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature_setting);
        signatureCommit= (TextView) findViewById(R.id.signature_setting_tijiao);
        signatureArow= (ImageView) findViewById(R.id.signture_setting_arow);
        signature= (EditText) findViewById(R.id.signature_setting_textview);
        signatureArow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignatureSettingActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
        signatureCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        commit();
                    }
                }.start();
            }
        });
    }

    public void commit(){
        DataApplication application= (DataApplication) getApplication();
        int userId=application.getId();
        try {
            SignatureAccount signatureAccount=new SignatureAccount(signature.getText().toString().trim(),userId);
            String stringBuilder=signatureAccount.getStringBuilder().toString().trim();
            application.setSignature(signature.getText().toString().trim());
            JSONObject jsonObject=new JSONObject(stringBuilder);
            application.setSignature(jsonObject.getString("result"));
            Intent intent=new Intent(SignatureSettingActivity.this,PersonalInfoActivity.class);
            startActivity(intent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
