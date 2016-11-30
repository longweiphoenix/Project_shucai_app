package com.example.first.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SubOrganicLifeActivity extends Activity {
    TextView title; //标题
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_ht);

        title = (TextView) findViewById(R.id.title);
        webView = (WebView) findViewById(R.id.web_view);

        webView.setWebViewClient(new WebViewClient());//设置一个内置浏览器
        webView.getSettings().setJavaScriptEnabled(true); //支持JS脚本
        webView.addJavascriptInterface(new WebViewInterface(SubOrganicLifeActivity.this),"demo");


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        title.setText(bundle.getString("title"));
        webView.loadUrl("https://zhidao.baidu.com/question/392590798609619205.html");
    }

    class WebViewInterface{
        Context context;
        public WebViewInterface(Context context){
            this.context = context;
        }
        @JavascriptInterface
        public void showToast(String name){

        }
    }
}
