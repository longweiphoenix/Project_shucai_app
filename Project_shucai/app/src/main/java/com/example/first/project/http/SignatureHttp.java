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
 * Created by Administrator on 2016/12/0005.
 */

public class SignatureHttp {
    String STR_URL = "http://10.0.2.2/index.php/home/index/signature?";
    String sign;
    int userId;

    URL url;
    public SignatureHttp(int userId,String sign) throws MalformedURLException {
        this.sign = sign;
        this.userId = userId;
        url = new URL(STR_URL+"userId"+userId+"&signature"+sign);
        stringBuilder = new StringBuilder();
        signature();
    }

    private StringBuilder stringBuilder;

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void signature(){
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(2000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s;
                while ((s = bufferedReader.readLine()) != null){
                    stringBuilder.append(s);
                }
                Log.i("stringBuilder==>",stringBuilder.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
