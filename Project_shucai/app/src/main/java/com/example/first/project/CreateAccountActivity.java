package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BaseActivity;
import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;
import com.example.first.project.http.CreateAccentHttp;
import com.example.first.project.utils.CaptchaUtils;
import com.example.first.project.utils.TimerUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.MalformedURLException;

import cn.smssdk.SMSSDK;

/**创建账号
 * Created by Administrator on 2016/11/0005.
 */

public class CreateAccountActivity extends BaseActivity {
    ImageView accountHead; //账户头像
    EditText nickName; // 昵称
    EditText phoneNumber; //手机号
    EditText verificationCode; //验证码
    Button sendCode;  //发送验证码
    EditText passWord; //密码
    Button createAccount; //创建账号
    TextView register; //登录
    LinearLayout parent_panel;

    Intent intent;
    LayoutInflater layoutInflater;//转换器



    WindowManager manager;
    DisplayMetrics metrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        layoutInflater = LayoutInflater.from(this);
        captcha = new CaptchaUtils(CreateAccountActivity.this);
        findView();
        //获取屏幕尺寸
        manager = getWindowManager();
        metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        w = metrics.widthPixels;
        h = metrics.heightPixels;

        register.setOnClickListener(onClickListener);
        accountHead.setOnClickListener(onClickListener);
        sendCode.setOnClickListener(onClickListener);
        createAccount.setOnClickListener(onClickListener);
    }

    CaptchaUtils captcha;
    CreateAccentHttp createAccentHttp;

    //点击事件
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.register: //登录
                    intent = new Intent(CreateAccountActivity.this,LoginPageActivity.class);
                    startActivity(intent);//跳转到登录页面
                    finish();
                    break;
                case R.id.account_head: //改变头像
                    setHeadPortraitWindow();
                    break;
                case R.id.send_code: //发送短信验证码
                    new TimerUtil(sendCode,1000*60,1000).start(); //倒计时

                    captcha.sendCaptcha(phoneNumber.getText().toString().trim());

                    break;
                case R.id.create:
                    captcha.commint(verificationCode.getText().toString().trim());
                    Log.i("验证码", verificationCode.getText().toString().trim());
                    if (captcha.bool){
                        new Thread(){
                            @Override
                            public void run() {
                                data();
                            }
                        }.start();
                    } else {
                        Toast.makeText(CreateAccountActivity.this,"验证码错误",Toast.LENGTH_LONG).show();
                        sendCode.setText("重新获取验证码");
                    }
                    captcha.cancellation();
                    break;
            }
        }
    };

    //访问接口
    public void data() {
        //注册
        Message message = new Message();
        try {
            createAccentHttp = new CreateAccentHttp(nickName.getText().toString().trim(),
                    passWord.getText().toString().trim(), phoneNumber.getText().toString().trim());
            String data = createAccentHttp.getStringBuilder().toString().trim();
            try {
                JSONObject jsonObject = new JSONObject(data);
                int status = jsonObject.getInt("status");
                if (status == 5 || status == 6) {  //注册成功
                    message.arg1 = 5;
                    handler.sendMessage(message);
                    intent = new Intent(CreateAccountActivity.this, MyHomePageActivity.class);
                    startActivity(intent);
                } else if (status == 1) { //用户已存在
                    message.arg1 = 1;
                    handler.sendMessage(message);
                } else if (status == 3) {  //密码不能为空
                    message.arg1 = 3;
                    handler.sendMessage(message);
                } else if (status == 0) {  // 手机号不能为空
                    message.arg1 = 0;
                    handler.sendMessage(message);
                } else if (status == 10){ //手机号已经被注册
                    message.arg1 = 10;
                    handler.sendMessage(message);
                } else if (status == -1){ //用户名不能为空
                    message.arg1 = -1;
                    handler.sendMessage(message);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        captcha.cancellation();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 == 5) {     
                Toast.makeText(CreateAccountActivity.this, "注册成功", Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == 1) {
                Toast.makeText(CreateAccountActivity.this, "用户已存在", Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == 3) {
                Toast.makeText(CreateAccountActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == 0) {
                Toast.makeText(CreateAccountActivity.this, "手机号不能为空", Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == 10) {
                Toast.makeText(CreateAccountActivity.this, "手机号已经备注册", Toast.LENGTH_LONG).show();
            } else if (msg.arg1 == -1) {
                Toast.makeText(CreateAccountActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
            }
        }
    };

    int w, h;
    PopupWindow cameraWindow;
    //创建选择头像弹出框
    public void setHeadPortraitWindow() {
        View view = layoutInflater.inflate(R.layout.chang_head_protrait, null);
        TextView camera = (TextView) view.findViewById(R.id.head_camera);//拍照获取头像
        TextView headChangeCancel = (TextView) view.findViewById(R.id.head_cancel);//取消更换头像
        TextView fromPhotoAlbum = (TextView) view.findViewById(R.id.from_photo_album);//从手机相册里选择头像图片
        //设置拍照 启用摄像头/待编辑
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = "";
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
                filePath = getCacheDir().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + "camera" + ".png";
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));
                startActivity(intent);
            }
        });
        //设置取消更换头像
        headChangeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraWindow.dismiss();
            }
        });
        //从相册里选择头像图片/待编辑
        fromPhotoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivity(intent);
            }
        });
        cameraWindow = new PopupWindow(view, w, h);
        cameraWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        cameraWindow.setOutsideTouchable(true);
        cameraWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
        cameraWindow.showAtLocation(parent_panel, Gravity.CENTER, 0, 0);
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
        parent_panel = (LinearLayout) findViewById(R.id.parent_panel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
