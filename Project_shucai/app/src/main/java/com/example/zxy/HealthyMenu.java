package com.example.zxy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.along.ui1project.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/2.
 */

public class HealthyMenu extends Activity{
    ViewPager viewPager;
    MenuViewPagerAdatper menuViewPagerAdatper;
    View view1,view2;
    ArrayList<View> views;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_menu_one);
        super.onCreate(savedInstanceState);
        view1=layoutInflater.inflate(R.layout.viewflipper_menu_layout,null);
        view2=layoutInflater.inflate(R.layout.viewflipper_menu_two_layout,null);
    }
}
