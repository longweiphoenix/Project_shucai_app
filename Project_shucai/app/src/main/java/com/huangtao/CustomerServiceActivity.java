package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.along.ui1project.R;

/**
 * Created by Long on 2016/11/30.
 */
public class CustomerServiceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service_ht);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
