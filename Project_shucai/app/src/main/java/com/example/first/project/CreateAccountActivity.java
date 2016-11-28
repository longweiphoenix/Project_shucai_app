package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.utils.TimerUtil;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

import static cn.smssdk.SMSSDK.submitUserInfo;

/**创建账号
 * Created by Administrator on 2016/11/0005.
 */

public class CreateAccountActivity extends Activity {
    ImageView accountHead; //账户头像
    EditText nickName; // 昵称
    EditText phoneNumber; //手机号
    EditText verificationCode; //验证码
    Button sendCode;  //发送验证码
    EditText passWord; //密码
    Button createAccount; //创建账号
    TextView register; //登录

    Intent intent;

    //短信验证的key和secret(mob.com)
    String APPKEY = "1963fd37dd7ed";
    String APPSECRET = "13c2ec6cf3cbe4906902b5cf00d4f710";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        //初始化SDK
        SMSSDK.initSDK(this,APPKEY,APPSECRET);

        findView();

        register.setOnClickListener(onClickListener);
        accountHead.setOnClickListener(onClickListener);
        sendCode.setOnClickListener(onClickListener);
    }

    //点击事件
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.register: //登录
                    intent = new Intent(CreateAccountActivity.this,LoginPageActivity.class);
                    startActivity(intent);//跳转到登录页面
                    break;
                case R.id.account_head: //改变头像

                    portrait();
                    break;
                case R.id.send_code: //短信验证

                    //注册手机号
                    RegisterPage register = new RegisterPage();
                    //注册回调事件
                    register.setRegisterCallback(new EventHandler(){
                        //事件完后后回调
                        @Override
                        public void afterEvent(int event, int result, Object data) {
                            //判断结果是否已经完成
                            if (result == SMSSDK.RESULT_COMPLETE){
                                //获取数据data(object)类型键值对方式存在
                                HashMap<String,Object> map = (HashMap<String, Object>) data;
                                //国家的信息
                                String country = (String) map.get("country");
                                //手机号信息
                                String phone = (String) map.get("phone");
                                info(country,phoneNumber.toString());
                            }

                        }
                    });
                    register.show(CreateAccountActivity.this);
                    new TimerUtil(sendCode,1000*60,1000).start();
                    break;
            }
        }
    };

    //提交用户信息
    public void info(String country,String phone){
        String uid = "1";
        submitUserInfo(uid,nickName.toString(),null,country,phone);
    }




    PopupWindow popupWindow;
    //弹出相机和相册对话框
    public void portrait(){
        //创建视图转换器
        LayoutInflater inflater = LayoutInflater.from(CreateAccountActivity.this);
        View view = inflater.inflate(R.layout.account_head_image,null);
        TextView camera = (TextView) view.findViewById(R.id.camera);
        TextView photo  = (TextView) view.findViewById(R.id.photo);
        //点击事件
        camera.setOnClickListener(new View.OnClickListener() { //点击相机，显示本地相机
            @Override
            public void onClick(View v) {//调用相机拍照

            }
        });
        photo.setOnClickListener(new View.OnClickListener() { //点击相册，显示本地相册
            @Override
            public void onClick(View v) {

            }
        });
        // /获取屏幕尺寸
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int x = metric.widthPixels; //获取屏幕宽度
        //创建对话框
        popupWindow = new PopupWindow(view,x,500);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(accountHead);

    }

    //找到控件
    public void findView(){
        accountHead = (ImageView) findViewById(R.id.account_head);
        nickName = (EditText) findViewById(R.id.nick_name);
        phoneNumber = (EditText) findViewById(R.id.phone_number);
        verificationCode = (EditText) findViewById(R.id.verification_code);
        sendCode = (Button) findViewById(R.id.send_code);
        passWord = (EditText) findViewById(R.id.passWord);
        createAccount = (Button) findViewById(R.id.create);
        register = (TextView) findViewById(R.id.register);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        SMSSDK.unregisterAllEventHandler();
    }
}
