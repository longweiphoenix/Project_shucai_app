package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/12/6.
 */
public class MyPersonaLsettings extends Activity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalsettings_ht);

        imageButton= (ImageButton) findViewById(R.id.gersezfah);


        imageButton.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.gersezfah:
                    finish();
               break;
            }
        }
    };
}
