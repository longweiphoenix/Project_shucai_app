package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;
import com.example.first.project.http.LoginAccount;
import com.example.first.project.vb.VBRegister;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**登录页面
 * Created by Administrator on 2016/11/0008.
 */

public class LoginPageActivity extends Activity {
    EditText info; //信息
    EditText passWord; //密码
    Button register; //登录
    TextView createAccount; //创建账号
    Intent intent;
    LinearLayout vx; //微信登录
    LinearLayout vb; //微博登录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        findView();



        createAccount.setOnClickListener(onClickListener);
        register.setOnClickListener(onClickListener);
        vb.setOnClickListener(onClickListener);

    }

    VBRegister vbRegister;
    //点击事件
    View.OnClickListener onClickListener =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.create_account:
                    intent = new Intent(LoginPageActivity.this,CreateAccountActivity.class);
                    startActivity(intent); //跳转到创建账号页面
                    finish();
                    break;
                case R.id.register: //登录
//                    new Thread(){
//                        @Override
//                        public void run() {
//                            login();
//                        }
//                    };
                    intent = new Intent(LoginPageActivity.this, MyHomePageActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.vb_register:
                    vbRegister = new VBRegister(LoginPageActivity.this);
                    break;

            }
        }
    };

    LoginAccount loginAccount;

    //判断字符串是不是电话号码
    public boolean isMobile(String info) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$");
        Matcher m = p.matcher(info);
        return m.matches();
    }
    //登录
    public void login(){
        try {
            //初始换
            loginAccount = new LoginAccount(info.getText().toString().trim(),
                    passWord.getText().toString().trim());

            String data = loginAccount.getStringBuilder().toString().trim();

            JSONObject object = new JSONObject(data);
            Message message = new Message();
            int status = object.getInt("status");
            if (isMobile(info.getText().toString().trim())){
               if (status == 0){
                   message.arg1 = 0;
                   handler.sendMessage(message);
                   intent = new Intent(LoginPageActivity.this, MyHomePageActivity.class);
                   startActivity(intent);
               }else if (status == -1){
                   message.arg1 = -1;
                   handler.sendMessage(message);
               }
            }else if (!isMobile(info.getText().toString().trim())){
                if (status == 0){  //登录成功
                    message.arg1 = 0;
                    handler.sendMessage(message);
                    intent = new Intent(LoginPageActivity.this, MyHomePageActivity.class);
                    startActivity(intent);
                }else if (status == -1){
                    message.arg1 = -1;
                    handler.sendMessage(message);
                }
            }else {
                message.arg1 = -2;
                handler.sendMessage(message);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 0){
                Toast.makeText(LoginPageActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
            }else if (msg.arg1 == -1){
                Toast.makeText(LoginPageActivity.this,"密码为空或密码错误",Toast.LENGTH_LONG).show();
            }else if (msg.arg1 == -2){
                Toast.makeText(LoginPageActivity.this,"用户名或手机号不能为空",Toast.LENGTH_LONG).show();
            }
        }
    };


    //找到控件
    public void findView(){
        info = (EditText) findViewById(R.id.phone_number);
        passWord = (EditText) findViewById(R.id.passWord);
        register = (Button) findViewById(R.id.register);
        createAccount = (TextView) findViewById(R.id.create_account);
        vx = (LinearLayout) findViewById(R.id.vx_register);
        vb = (LinearLayout) findViewById(R.id.vb_register);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        vbRegister.callBack(requestCode,resultCode,data);
    }
}
