package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.ui1project.MyHomePage;
import com.example.along.ui1project.R;

/**登录页面
 * Created by Administrator on 2016/11/0008.
 */

public class LoginPageActivity extends Activity {
    EditText phoneNumber; //手机号
    EditText passWord; //密码
    Button register; //登录
    TextView createAccount; //创建账号
    LinearLayout vx; //微信登录
    LinearLayout vb; //微博登录

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        findView();

        createAccount.setOnClickListener(onClickListener);

    }
    //点击事件
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.create_account:
                    intent = new Intent(LoginPageActivity.this,CreateAccountActivity.class);
                    startActivity(intent); //跳转到创建账号页面
                    break;
                case R.id.register:
                    intent = new Intent(LoginPageActivity.this, MyHomePage.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    //找到控件
    public void findView(){
        phoneNumber = (EditText) findViewById(R.id.phone_number);
        passWord = (EditText) findViewById(R.id.passWord);
        register = (Button) findViewById(R.id.register);
        createAccount = (TextView) findViewById(R.id.create_account);
        vx = (LinearLayout) findViewById(R.id.vx_register);
        vb = (LinearLayout) findViewById(R.id.vb_register);
    }
}
