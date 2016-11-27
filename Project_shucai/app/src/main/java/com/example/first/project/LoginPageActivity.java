package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.MyHomePage;
import com.example.along.ui1project.R;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

/**登录页面
 * Created by Administrator on 2016/11/0008.
 */

public class LoginPageActivity extends Activity {
    EditText phoneNumber; //手机号
    EditText passWord; //密码
    Button register; //登录
    TextView createAccount; //创建账号
    Intent intent;
    LinearLayout vx; //微信登录
    LinearLayout vb; //微博登录

    AuthInfo authInfo;
    SsoHandler mSsoHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        findView();

        createAccount.setOnClickListener(onClickListener);
        register.setOnClickListener(onClickListener);
        vb.setOnClickListener(onClickListener);

    }
    //点击事件
    View.OnClickListener onClickListener =  new View.OnClickListener() {
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
                case R.id.vb_register:
                    authInfo = new AuthInfo(LoginPageActivity.this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE);
                    mSsoHandler = new SsoHandler(LoginPageActivity.this, authInfo);
                    mSsoHandler. authorize(new AuthListener());
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
    //微博登录
    private class AuthListener implements WeiboAuthListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onComplete(Bundle values) {
            Toast.makeText(LoginPageActivity.this, "登录成功", Toast.LENGTH_SHORT)
                    .show();
            Oauth2AccessToken accessToken = Oauth2AccessToken
                    .parseAccessToken(values);
            AccessTokenKeeper keeper = new AccessTokenKeeper();
            keeper.writeAccessToken(LoginPageActivity.this,accessToken);

            if (accessToken != null && accessToken.isSessionValid()) {
                Log.i("accessToken==>",""+accessToken);
            }
        }
        @Override
        public void onWeiboException(WeiboException e) {
            Toast.makeText(LoginPageActivity.this, "微博异常", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onCancel() {
            Toast.makeText(LoginPageActivity.this, "取消授权", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null){
            mSsoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
    }
}
