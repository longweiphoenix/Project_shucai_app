package com.huangtao;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.huangtao.Adapter.MyDarFragmentList;
import com.huangtao.Adapter.MyHayoFragmentList;
import com.huangtao.Adapter.MyLocFragmentList;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyWodegzu extends Activity {
    ImageButton back; //返回上级页面
    TextView textView;
    TextView getTextView;
    TextView getGetTextView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodegzu_text_layout);
        createFragment();

        back = (ImageButton) findViewById(R.id.back);
        textView = (TextView) findViewById(R.id.textview_dare);
        getTextView = (TextView) findViewById(R.id.hayo);
        getGetTextView = (TextView) findViewById(R.id.loc);
        linearLayout = (LinearLayout) findViewById(R.id.viewpager_lero);

        textView.setOnClickListener(onClickListener);
        getTextView.setOnClickListener(onClickListener);
        getGetTextView.setOnClickListener(onClickListener);
        back.setOnClickListener(onClickListener);
    }

    MyDarFragmentList fragmentList;
    MyHayoFragmentList myHayoFragmentList;
    MyLocFragmentList myLocFragmentList;
    FragmentManager fragmentManager;

    public void createFragment(){
        fragmentList = new MyDarFragmentList();
        myHayoFragmentList=new MyHayoFragmentList();
        myLocFragmentList=new MyLocFragmentList();
        fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction().add(R.id.viewpager_lero,fragmentList).commit();
        fragmentManager.beginTransaction().add(R.id.viewpager_lero,myHayoFragmentList).commit();
        fragmentManager.beginTransaction().add(R.id.viewpager_lero,myLocFragmentList).commit();
        fragmentManager.beginTransaction().hide(myHayoFragmentList).commit();
    }

    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.textview_dare:
                    textView.setTextColor(getResources().getColor(R.color.green));
                    getTextView.setTextColor(getResources().getColor(R.color.black));
                    getGetTextView.setTextColor(getResources().getColor(R.color.black));

                    fragmentManager.beginTransaction().show(fragmentList).commit();
                    fragmentManager.beginTransaction().hide(myHayoFragmentList).commit();
                    fragmentManager.beginTransaction().hide(myLocFragmentList).commit();
                    break;
                case R.id.hayo:
                    textView.setTextColor(getResources().getColor(R.color.black));
                    getTextView.setTextColor(getResources().getColor(R.color.green));
                    getGetTextView.setTextColor(getResources().getColor(R.color.black));

                    fragmentManager.beginTransaction().show(myHayoFragmentList).commit();
                    fragmentManager.beginTransaction().hide(fragmentList).commit();
                    fragmentManager.beginTransaction().hide(myLocFragmentList).commit();
                    break;
                case R.id.loc:
                    textView.setTextColor(getResources().getColor(R.color.black));
                    getTextView.setTextColor(getResources().getColor(R.color.black));
                    getGetTextView.setTextColor(getResources().getColor(R.color.green));

                    fragmentManager.beginTransaction().show(myLocFragmentList).commit();
                    fragmentManager.beginTransaction().hide(fragmentList).commit();
                    fragmentManager.beginTransaction().hide(myHayoFragmentList).commit();
                    break;
                case R.id.back:
                    finish();
                    break;
            }
        }
    };
}

