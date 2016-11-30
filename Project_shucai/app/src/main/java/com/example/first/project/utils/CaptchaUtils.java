package com.example.first.project.utils;

import android.content.Context;
import android.util.Log;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

/**
 * 短信验证码
 * Created by Administrator on 2016/11/0030.
 */

public class CaptchaUtils {
    //短信验证的key和secret(mob.com)
    private static final String APPKEY = "1963fd37dd7ed";
    private static final String APPSECRET = "13c2ec6cf3cbe4906902b5cf00d4f710";
    private static final String COUNTRY = "86";
    Context context;
    String phoneNumb;
    public CaptchaUtils(Context context){
        this.context = context;
        init();
    }

    public void init(){
        SMSSDK.initSDK(context,APPKEY,APPSECRET);
        EventHandler eh=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        Log.i("验证码正确","回调成功");
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }
    public void sendCaptcha( String phoneNumb){ //发送验证码
        this.phoneNumb=phoneNumb;
        SMSSDK.getVerificationCode(COUNTRY, phoneNumb, new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String country, String phone) {
                return false;
            }
        });

    }
    public void commint( String code){//从用户手机中上传验证码到服务器
        SMSSDK.submitVerificationCode(COUNTRY,phoneNumb,code);
    }

    public void cancellation(){//注销验证码请求
        SMSSDK.unregisterEventHandler(new EventHandler());
    }


}
