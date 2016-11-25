package com.example.first.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/0011.
 */

public class OrganicLifeActivity extends Activity {

    ImageView back; //返回上级
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organic_life);

        back = (ImageView) findViewById(R.id.back);
    }

}
