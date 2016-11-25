package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/30.
 */
public class Cooking extends Activity {
    TextView parepre,
             process;
    LinearLayout menuParepre,
                  menuProcess;
    ImageView menuArowImageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_prepare);
        parepre = (TextView) findViewById(R.id.parepre_button);
        process = (TextView) findViewById(R.id.process_button);
        menuParepre = (LinearLayout) findViewById(R.id.menu_parepre_linearlayout);
        menuProcess= (LinearLayout) findViewById(R.id.menu_process_linearlayout);
        menuArowImageView = (ImageView) findViewById(R.id.menu_arow_imageview);
        menuArowImageView.setOnClickListener(listener);
        parepre.setOnClickListener(listener);
        process.setOnClickListener(listener);
    }
    //做菜流程和准备的点击切换
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
           switch (v.getId()){
               case R.id.parepre_button:
                   parepre.setTextColor(getResources().getColor(R.color.fontgreen));
                   process.setTextColor(getResources().getColor(R.color.fontblack1));
                   menuProcess.setVisibility(View.GONE);
                   menuParepre.setVisibility(View.VISIBLE);
                   break;
               case R.id.process_button:
                   process.setTextColor(getResources().getColor(R.color.fontgreen));
                   parepre.setTextColor(getResources().getColor(R.color.fontblack1));
                   menuParepre.setVisibility(View.GONE);
                   menuProcess.setVisibility(View.VISIBLE);
                   break;
               case R.id.menu_arow_imageview:
                   intent=new Intent(Cooking.this,HealthyMenuOne.class);
                   startActivity(intent);
                   break;
           }
        }
    };
}
