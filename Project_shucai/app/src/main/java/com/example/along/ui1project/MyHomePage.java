package com.example.along.ui1project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.along.ui1project.fragment.HomePageFragment;
import com.example.along.ui1project.fragment.MePageFragment;
import com.example.along.ui1project.fragment.ShopShowFragment;
import com.huangtao.ShoppingCarActivity;

/**
 * Created by Long on 2016/10/25.
 */
public class MyHomePage extends Activity implements View.OnTouchListener {
    TextView homePage,//底部的三个按钮
            shop,
            me,
            search,shoppingCar,//首页顶部按钮
            setting_me,shopping_car_me,//我的页面的顶部
            shopping_car_shop,search_goods_shop;//商铺页面的按钮
    RelativeLayout relHome,relShop,relMe;
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
        linearLayout = (LinearLayout) findViewById(R.id.container);
        homePage = (TextView) findViewById(R.id.home);
        /*二级界面三个页面的显示*/
        shop = (TextView) findViewById(R.id.shop);
        me = (TextView) findViewById(R.id.user);
        group = (RadioGroup) findViewById(R.id.group);
        /*二级界面的三个页面点击事件*/
        shop.setOnClickListener(onClickListener);
        me.setOnClickListener(onClickListener);
        homePage.setOnClickListener(onClickListener);
        //三个顶部布局
        relHome= (RelativeLayout) findViewById(R.id.rel_home);
        relShop= (RelativeLayout) findViewById(R.id.rel_shop);
        relMe= (RelativeLayout) findViewById(R.id.rel_me);
        //home顶部
        search= (TextView) findViewById(R.id.search_home);
        shoppingCar= (TextView) findViewById(R.id.shopping_car_home);
        //搜索跳转
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyHomePage.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        //购物车跳转
        shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyHomePage.this, ShoppingCarActivity.class);
                startActivity(intent);
            }
        });


        //shop顶部
        shopping_car_shop= (TextView) findViewById(R.id.shopping_car_shop);
        search_goods_shop= (TextView) findViewById(R.id.search_goods_shop);
        shopping_car_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //跳转购物车  需要bundle数据？？
                Intent intent=new Intent(MyHomePage.this,ShoppingCarActivity.class);
                startActivity(intent);
            }
        });
        search_goods_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到搜索界面 需要bundle数据？？
                Intent intent=new Intent(MyHomePage.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        //我的顶部
        setting_me= (TextView) findViewById(R.id.setting_me);
        shopping_car_me= (TextView) findViewById(R.id.shopping_car_me);
        setting_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人设置界面 需要bundle数据？？
                Intent intent=new Intent(MyHomePage.this,PersonalInfo.class);
                startActivity(intent);
            }
        });
        shopping_car_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转购物车  需要bundle数据？？
                Intent intent=new Intent(MyHomePage.this,ShoppingCarActivity.class);
                startActivity(intent);
            }
        });


        manager = getFragmentManager();
        homePageFragment = new HomePageFragment();
        shopShowFragment = new ShopShowFragment();
        mePageFragment = new MePageFragment();
        manager.beginTransaction().add(R.id.container, shopShowFragment, "homepage").commit();
        manager.beginTransaction().add(R.id.container, mePageFragment, "homepage").commit();
        manager.beginTransaction().hide(shopShowFragment).commit();
        manager.beginTransaction().hide(mePageFragment).commit();
        manager.beginTransaction().add(R.id.container, homePageFragment, "homepage").commit();
        mGestureDetector = new GestureDetector(this, gestureDetector);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.home:
                    relHome.setVisibility(View.VISIBLE);
                    relShop.setVisibility(View.GONE);
                    relMe.setVisibility(View.GONE);
                    manager.beginTransaction().hide(shopShowFragment).commit();
                    manager.beginTransaction().hide(mePageFragment).commit();
                    manager.beginTransaction().show(homePageFragment).commit();
                    break;
                case R.id.shop:
                    relHome.setVisibility(View.GONE);
                    relShop.setVisibility(View.VISIBLE);
                    relMe.setVisibility(View.GONE);
                    manager.beginTransaction().hide(homePageFragment).commit();
                    manager.beginTransaction().hide(mePageFragment).commit();
                    manager.beginTransaction().show(shopShowFragment).commit();
                    break;
                case R.id.user:
                    relHome.setVisibility(View.GONE);
                    relShop.setVisibility(View.GONE);
                    relMe.setVisibility(View.VISIBLE);
                    manager.beginTransaction().hide(homePageFragment).commit();
                    manager.beginTransaction().hide(shopShowFragment).commit();
                    manager.beginTransaction().show(mePageFragment).commit();
                    break;
            }
        }
    };
    GestureDetector.OnGestureListener gestureDetector = new GestureDetector.OnGestureListener() {

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
            return false;
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
