package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.PersonalInfoActivity;
import com.example.along.ui1project.R;
import com.example.first.project.application.DataApplication;
import com.example.zxy.http.NameAccount;

import org.json.JSONException;
import org.json.JSONObject;

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
        DataApplication application= (DataApplication) getApplication();//获得Application对象
        int userId=application.getId();
        try {
           NameAccount nameAccount=new NameAccount(name.getText().toString().trim(),userId);
            //获取网络请求返回的JSon数据
           String stringBuilder=nameAccount.getStringBuilder().toString().trim();
            //将name设为全局
            application.setName(name.getText().toString().trim());
            Log.i("name===========",application.getName());

            JSONObject jsonObject=new JSONObject(stringBuilder);
            int status=jsonObject.getInt("status");
            Message message=new Message();
            if(status==1){
                message.arg1=1;
                handler.sendMessage(message);
                application.setName(jsonObject.getString("result"));

//                LayoutInflater layoutInflater=LayoutInflater.from(NameSettingActivity.this);
//                View view=layoutInflater.inflate(R.layout.info_personal,null);
//                TextView name1= (TextView) view.findViewById(R.id.user_nick_name);
//                name1.setText(name.getText().toString().trim());
                Intent intent=new Intent(NameSettingActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }else if(status==0){
                message.arg1=0;
                handler.sendMessage(message);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.arg1==1){
                Toast.makeText(NameSettingActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
            }else if(msg.arg1==0){
                Toast.makeText(NameSettingActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            }
        }
    };
}
