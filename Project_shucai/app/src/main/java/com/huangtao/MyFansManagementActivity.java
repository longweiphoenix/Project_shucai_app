package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.BaseActivity;
import com.example.along.ui1project.R;

/**
 * Created by Long on 2016/11/30.
 */
public class MyFansManagementActivity extends BaseActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans_ht);

        imageButton= (ImageButton) findViewById(R.id.fesdefah);

        imageButton.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fesdefah:
                    finish();
                    break;
            }
        }
    };
}
