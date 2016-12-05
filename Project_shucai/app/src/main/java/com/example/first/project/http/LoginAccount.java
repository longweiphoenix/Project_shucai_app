package com.example.first.project.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/0002.
 */

public class LoginAccount {
    String STR_URL = "http://10.0.2.2/index.php/home/index/login?";
    String username;
    String phonenum;
    String passWord;

    URL url;
    public LoginAccount(String info,String passWord) throws MalformedURLException {
        this.passWord = passWord;
        if (isMobile(info)){
            this.username = info;
            url = new URL(STR_URL+"username="+info+"&password="+passWord);
        } else {
            this.phonenum = info;
            url = new URL(STR_URL+"phonenum="+info+"&password="+passWord);
        }
        stringBuilder = new StringBuilder();
        login();
    }


    //判断字符串是不是电话号码
    public boolean isMobile(String info) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$");
        Matcher m = p.matcher(info);
        return m.matches();
    }

    private StringBuilder stringBuilder; //用于缓存

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void login(){
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK){

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s;
                while ( (s = bufferedReader.readLine()) != null){
                    stringBuilder.append(s);
                }
                Log.i("stringBuilder===>",stringBuilder.toString().trim());
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
