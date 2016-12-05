package com.example.first.project.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/0001.
 */

public class CreateAccentHttp {
    String STR_URL = "http://10.0.2.2/index.php/home/index/register?";
    String username;
    String password;
    String phonenumb;

    private StringBuilder stringBuilder;

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    URL url;
    public CreateAccentHttp( String username,String password, String phonenumb) throws MalformedURLException {
        this.username = username;
        this.password = password;
        this.phonenumb = phonenumb;
        url = new URL(STR_URL+"username="+username+"&password="+password+"&phonenum="+phonenumb);
        stringBuilder = new StringBuilder(); //用于缓存
        register();
    }
    public void register(){
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
