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
import com.example.first.project.utils.TimerUtil;

import java.io.File;
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
    LinearLayout parent_panel;

    Intent intent;
    LayoutInflater layoutInflater;//转换器

    //短信验证的key和secret(mob.com)
    String APPKEY = "1963fd37dd7ed";
    String APPSECRET = "13c2ec6cf3cbe4906902b5cf00d4f710";


    WindowManager manager;
    DisplayMetrics metrics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        //初始化SDK
        SMSSDK.initSDK(this,APPKEY,APPSECRET);
        layoutInflater = LayoutInflater.from(this);
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
                    setHeadPortraitWindow();

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
