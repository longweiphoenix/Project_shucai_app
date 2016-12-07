package com.example.along.ui1project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.first.project.application.DataApplication;

import com.example.first.project.application.DataApplication;

import com.example.zxy.NameSettingActivity;
import com.example.zxy.SignatureSettingActivity;

import java.io.File;

/**
 * Created by Long on 2016/10/20.
 */
public class PersonalInfoActivity extends Activity {
    TextView info_back_arrow,//个人信息返回箭头
            user_nick_name,//用户昵称
            head_portrait_next_arrow,//头像箭头
            nick_name_next_arrow,//昵称后的箭头
            user_sex,//用户性别
            user_sex_next_arrow,//性别后的箭头
            personalized_edit_signature,//个人签名
            personalized_edit_signature_next_arrow,//个人签名后的箭头
            camera,//相机
            fromPhotoAlbum;//相册


    ImageView info_head_portrait;//用户头像
    LayoutInflater layoutInflater;//转换器
    PopupWindow cameraWindow, sexualChange;//更换头像弹
    //更换用户头像
    LinearLayout info_head_change, parent_panel, name_setting,setting_signature,
            sexual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_personal);
        manager = getWindowManager();
        metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        w = metrics.widthPixels;
        h = metrics.heightPixels;
        layoutInflater = LayoutInflater.from(this);//视图转换器
        info_back_arrow = (TextView) findViewById(R.id.info_back_arrow);//个人信息返回箭头
        info_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user_nick_name = (TextView) findViewById(R.id.user_nick_name);//用户昵称
        //user_nick_name.setText();
        head_portrait_next_arrow = (TextView) findViewById(R.id.head_portrait_next_arrow);//头像箭头
        nick_name_next_arrow = (TextView) findViewById(R.id.nick_name_next_arrow);//昵称后的箭头
        user_sex = (TextView) findViewById(R.id.user_sex);//用户性别
        sexual = (LinearLayout) findViewById(R.id.sexual);
        user_sex_next_arrow = (TextView) findViewById(R.id.user_sex_next_arrow);//性别后的箭头
        personalized_edit_signature = (TextView) findViewById(R.id.personalized_edit_signature);//个人签名
        personalized_edit_signature_next_arrow = (TextView) findViewById(R.id.personalized_edit_signature_next_arrow);//个人签名后的箭头
        findViewById(R.id.setting_signature).setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalInfoActivity.this, SignatureSettingActivity.class);
                startActivity(intent);
            }
        });
        DataApplication application= (DataApplication) getApplication();
        user_nick_name.setText(application.getName());//更改昵称

        personalized_edit_signature.setText(application.getSignature());//更改个性签名
        user_nick_name.setText(application.getName());
        info_head_portrait = (ImageView) findViewById(R.id.info_head_portrait);//用户头像
        info_head_change = (LinearLayout) findViewById(R.id.info_head_change);//更换用户头像
        name_setting = (LinearLayout) findViewById(R.id.name_setting);
        name_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalInfoActivity.this, NameSettingActivity.class);
                startActivity(intent);
            }
        });
        parent_panel = (LinearLayout) findViewById(R.id.parent_panel);
        info_head_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHeadPortraitWindow();
            }
        });
        sexual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChangeSexualWindow();
            }
        });
    }

    WindowManager manager;
    DisplayMetrics metrics;
    int w, h;

    //创建选择头像弹出框
    public void setHeadPortraitWindow() {
        View view = layoutInflater.inflate(R.layout.chang_head_protrait, null);

        camera = (TextView) view.findViewById(R.id.head_camera);//拍照获取头像
        TextView headChangeCancel = (TextView) view.findViewById(R.id.head_cancel);//取消更换头像
        fromPhotoAlbum = (TextView) view.findViewById(R.id.from_photo_album);//从手机相册里选择头像图片
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
    RadioButton sexual_male,sexual_female;
    //更换性别
    public void setChangeSexualWindow() {
       //将性别选择器转换成view
        View view = layoutInflater.inflate(R.layout.change_sexual_window, null);
        sexual_male = (RadioButton) view.findViewById(R.id.sexual_male);
        sexual_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                    if(isChecked){
                        sexual_male.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.title_font_color));
                        sexual_female.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.view_margin_line));
                    }else{
                        sexual_male.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.view_margin_line));
                        sexual_female.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.title_font_color));

                    }

            }
        });
        sexual_female = (RadioButton) view.findViewById(R.id.sexual_female);
        sexual_female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sexual_female.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.title_font_color));
                sexual_male.setTextColor(PersonalInfoActivity.this.getResources().getColor(R.color.view_margin_line));
            }
        });
        sexualChange = new PopupWindow(view, w, h / 2);
        sexualChange.setBackgroundDrawable(new ColorDrawable(0x00000000));
        sexualChange.setOutsideTouchable(true);
        sexualChange.showAsDropDown(personalized_edit_signature);
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexualChange.dismiss();
            }
        });



        view.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex=(sexual_female.isChecked())?"女":"男";
                Toast.makeText(PersonalInfoActivity.this, "您的性别为"+sex, Toast.LENGTH_SHORT).show();
                //性别设为男或女，上传数据库？
                sexualChange.dismiss();
            }
        });
    }
}
