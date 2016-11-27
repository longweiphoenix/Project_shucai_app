package com.example.along.ui1project;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.along.ui1project.fragment.HomePageFragment;
import com.example.along.ui1project.fragment.MeAdapter;
import com.example.along.ui1project.fragment.MePageFragment;
import com.example.along.ui1project.fragment.ShopShowFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/10/25.
 */
public class MyHomePage extends Activity implements View.OnTouchListener{
    TextView homePage,
            shop,
            me;
    ViewFlipper flipper;
    LinearLayout linearLayout;
    FragmentManager manager;
    RadioGroup group;
    HomePageFragment homePageFragment;
    ShopShowFragment shopShowFragment;
    MePageFragment mePageFragment;
    GestureDetector mGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_ht);
        flipper= (ViewFlipper) findViewById(R.id.view_flipper);
        linearLayout= (LinearLayout) findViewById(R.id.container);
        homePage= (TextView) findViewById(R.id.home);
        /*二级界面三个页面的显示*/
        shop= (TextView) findViewById(R.id.shop);
        me= (TextView) findViewById(R.id.user);
        group= (RadioGroup) findViewById(R.id.group);
        shop.setOnClickListener(onClickListener);
        me.setOnClickListener(onClickListener);
        homePage.setOnClickListener(onClickListener);


        manager=getFragmentManager();
        homePageFragment=new HomePageFragment();
        shopShowFragment=new ShopShowFragment();
        mePageFragment=new MePageFragment();
       /* manager.putFragment(savedInstanceState,"homepage",homePageFragment);
        manager.putFragment(savedInstanceState,"shopshow",shopShowFragment);
        manager.putFragment(savedInstanceState,"mepage",mePageFragment);*/

        manager.beginTransaction().add(R.id.container,shopShowFragment,"homepage").commit();
        manager.beginTransaction().add(R.id.container,mePageFragment,"homepage").commit();
        manager.beginTransaction().hide(shopShowFragment).commit();
        manager.beginTransaction().hide(mePageFragment).commit();
        manager.beginTransaction().add(R.id.container,homePageFragment,"homepage").commit();
        mGestureDetector=new GestureDetector(this,gestureDetector);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.home:

                    manager.beginTransaction().hide(shopShowFragment).commit();
                    manager.beginTransaction().hide(mePageFragment).commit();
                    manager.beginTransaction().show(homePageFragment).commit();
                    break;
                case R.id.shop:
                    manager.beginTransaction().hide(homePageFragment).commit();
                    manager.beginTransaction().hide(mePageFragment).commit();
                    manager.beginTransaction().show(shopShowFragment).commit();
                    break;
                case R.id.user:
                    manager.beginTransaction().hide(homePageFragment).commit();
                    manager.beginTransaction().hide(shopShowFragment).commit();
                    manager.beginTransaction().show(mePageFragment).commit();
                    break;
            }
        }
    };
    GestureDetector.OnGestureListener gestureDetector=new GestureDetector.OnGestureListener(){

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

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if ((e1.getX() - e2.getX()) > 20 && Math.abs(velocityX) > 0) {
                manager.beginTransaction().show(mePageFragment).commit();
            } else if (e2.getX() - e1.getX() > 20 && Math.abs(velocityX) > velocityY) {
                manager.beginTransaction().show(homePageFragment).commit();
            }
            return true;
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}
