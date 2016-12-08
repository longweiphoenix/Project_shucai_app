package com.example.first.project;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.BaseActivity;
import com.example.along.ui1project.R;

/**
 * Created by Long on 2016/11/30.
 */
public class CustomerServiceActivity extends BaseActivity {
    ListView listView;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service_ht);
        //返回上级
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.list_view);
        editText = (EditText) findViewById(R.id.question);
        textView = (TextView) findViewById(R.id.add_send);

    }
}
