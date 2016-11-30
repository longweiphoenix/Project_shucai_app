package com.example.first.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SubOrganicLifeActivity extends Activity {

    ImageView back;
    ImageView share;
    ImageView enshrine;

    TextView title; //标题
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_ht);

        title = (TextView) findViewById(R.id.title);
        webView = (WebView) findViewById(R.id.web_view);
        back = (ImageView) findViewById(R.id.arow);
        share = (ImageView) findViewById(R.id.share);
        enshrine  = (ImageView) findViewById(R.id.enshrine);

        back.setOnClickListener(clickListener);
        share.setOnClickListener(clickListener);
        enshrine.setOnClickListener(clickListener);


        webView.setWebViewClient(new WebViewClient());//设置一个内置浏览器
        webView.getSettings().setJavaScriptEnabled(true); //支持JS脚本
        webView.addJavascriptInterface(new WebViewInterface(SubOrganicLifeActivity.this),"demo");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String str=bundle.getString("title");
        title.setText(str);
        try {
            URL url = new URL("https://zhidao.baidu.com/search?word="+str);
            webView.loadUrl(url.toString().trim());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.arow:
                    finish();
                    break;
                case R.id.share:  //分享
                    break;
                case R.id.enshrine: //收藏
                    break;
            }
        }
    };

    class WebViewInterface{
        Context context;
        public WebViewInterface(Context context){
            this.context = context;
        }
        @JavascriptInterface
        public void showToast(String name){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
