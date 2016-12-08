package com.example;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.along.ui1project.R;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String EXIT_ACTION = "com.example.app.EXIT_APP";
    private ExitBroadcastReceiver receiver;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //动态注册广播
        receiver = new ExitBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EXIT_ACTION);
        registerReceiver(receiver, intentFilter);
    }
    class ExitBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(EXIT_ACTION)) {
                BaseActivity.this.finish();
                Log.d("EXIT", BaseActivity.this.getLocalClassName());
            }
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        if(receiver != null) {
            //反注册广播
            unregisterReceiver(receiver);
        }
    }
}
