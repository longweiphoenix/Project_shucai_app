package com.example.zxy.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/6.
 */

public class NameAccount {
    String name_url="http://10.0.2.2/index.php/home/index/name?";
    int userId;
    String username;
    URL url;
    public NameAccount(String username,int userId) throws MalformedURLException {
        this.username=username;
        this.userId=userId;
        url=new URL(name_url+"username="+username+"&userId="+userId);
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
                 InputStream inputStream =httpURLConnection.getInputStream();
                 InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                 BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                 String s;
                 while ((s=bufferedReader.readLine())!=null){
                     stringBuilder.append(s);
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
