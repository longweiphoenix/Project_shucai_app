package com.example.along.ui1project;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    List<Bitmap> imgs;
    int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        new Thread(){
            @Override
            public void run() {
                setImageGallery("http://apis.juhe.cn/cook/queryid?id=1001");
            }
        }.start();
        String str ="12543531";
        Log.i("i",imgs.toString());
    }
    public int setImageGallery(String httpUrl) {
        imgs= new ArrayList<>();
        BufferedReader reader = null;
        String result = null;
        m=2;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            m=1;
            connection.setRequestProperty("apikey", "7982f2f2086663ad0392d5b6398ec112");
            Log.i("connection", "connectionning");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                Log.i("connection", "connect_success");
                InputStream is = connection.getInputStream();
                m=2;
                reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
                String strReader = null;
                while ((strReader = reader.readLine()) != null) {
                    stringBuilder.append(strReader);
                    stringBuilder.append("\r\n");
                }
                result = stringBuilder.toString();
                Log.i("i",result);
                /*JSONArray array=new JSONArray(result);
                JSONObject object=array.getJSONObject(0);
                String str1=object.getString("img");
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inJustDecodeBounds=true;
                options.outHeight=options.outHeight*200/options.outWidth;
                options.outWidth=200;
                Bitmap bitmap=BitmapFactory.decodeFile("http://tnfs.tngou.net/img",options);
                imgs.add(bitmap);*/
                reader.close();
                is.close();
            }else{
                Log.i("connection", "connection_failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }
}
