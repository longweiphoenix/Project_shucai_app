package com.example.zxy.http;

import android.content.Intent;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/7.
 */

public class FlashImfomation  {
    String imfor_url="http://10.0.2.2/index.php/home/index/personinfo?";
    int userId;
    String username;
    String signature;
    URL url;
    public FlashImfomation(int userId) throws MalformedURLException {
        this.userId=userId;
        url=new URL(imfor_url+"userid="+userId);
        stringBuilder=new StringBuilder();
        update();
    }
    private StringBuilder stringBuilder;
    public StringBuilder getStringBuilder(){return stringBuilder;}
    public void update(){
        try {
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode()==httpURLConnection.HTTP_OK){
                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String s;
                while ((s=bufferedReader.readLine())!=null){
                    stringBuilder.append(s);
                }
                Log.i("String========",stringBuilder.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
