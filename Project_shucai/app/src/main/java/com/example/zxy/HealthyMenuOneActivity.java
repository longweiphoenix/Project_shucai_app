package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/10/30.
 */
public class HealthyMenuOneActivity extends Activity {
    Button heartOne;//收藏
    boolean isFavorite=true;
    ViewFlipper viewFlipper;
    Button menuButton;
    ImageView menuArowImageView;
    GestureDetector gestureDetector;
    LayoutInflater layoutInflater;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_one);
        viewFlipper= (ViewFlipper) findViewById(R.id.menu_viewflipper);
        menuButton= (Button) findViewById(R.id.menu_button);
        heartOne= (Button) findViewById(R.id.heart_one);
        menuArowImageView= (ImageView) findViewById(R.id.menu_arow_imageview);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HealthyMenuOneActivity.this,CookingActivity.class);
                startActivity(intent);
            }
        });
        menuArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthyMenuOneActivity.this, MyHomePageActivity.class);
                startActivity(intent);
            }
        });
        layoutInflater=LayoutInflater.from(HealthyMenuOneActivity.this);
        viewFlipper.setFlipInterval(10000000);
        viewFlipper.startFlipping();
        gestureDetector=new GestureDetector(this,gestureListener);
        heartOne.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {
                if(isFavorite){
                    heartOne.setBackground(getResources().getDrawable(R.mipmap.heart_green));
                    isFavorite=false;
                    Toast.makeText(HealthyMenuOneActivity.this,"收藏成功！！",Toast.LENGTH_SHORT).show();
                }else{
                    heartOne.setBackground(getResources().getDrawable(R.mipmap.heart_white));
                    isFavorite=true;
                    Toast.makeText(HealthyMenuOneActivity.this,"取消收藏成功！！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    GestureDetector.OnGestureListener gestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override               //滑动起始点  //滑动结束点
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int i =0;
            //向右滑动
            if(i<e2.getX()-e1.getX()){
                viewFlipper.setInAnimation(HealthyMenuOneActivity.this,R.anim.in_leftright);
                viewFlipper.setOutAnimation(HealthyMenuOneActivity.this,R.anim.out_leftright);
                viewFlipper.stopFlipping();
                viewFlipper.showPrevious();
                viewFlipper.startFlipping();
            }
            //向左滑动
            else if(i>e2.getX()-e1.getX()){
                viewFlipper.setInAnimation(HealthyMenuOneActivity.this,R.anim.in_rightleft);
                viewFlipper.setOutAnimation(HealthyMenuOneActivity.this,R.anim.out_rightleft);
                viewFlipper.stopFlipping();
                viewFlipper.showNext();
                viewFlipper.startFlipping();
            }
            return true;
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}

