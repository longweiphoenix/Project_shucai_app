package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.first.project.utils.CaptchaUtils;
import com.example.first.project.utils.TimerUtil;

import java.io.File;

import cn.smssdk.SMSSDK;

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
                    setHeadPortraitWindow();
                    break;
                case R.id.send_code: //短信验证
                    new TimerUtil(sendCode,1000*60,1000).start();

                    captcha.sendCaptcha(phoneNumber.getText().toString().trim());

                    break;
                case R.id.create:
                    captcha.commint(verificationCode.getText().toString().trim());
                    Log.i("验证码",verificationCode.getText().toString().trim());
                    captcha.cancellation();
                    break;
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
        //解除注册
        SMSSDK.unregisterAllEventHandler();
    }
}
