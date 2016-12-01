package com.example.along.ui1project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.along.ui1project.fragment.HomePageFragment;
import com.example.along.ui1project.fragment.MePageFragment;
import com.example.along.ui1project.fragment.ShopShowFragment;
import com.huangtao.MyShoppingcartchoose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 2016/10/25.
 */
public class MyHomePageActivity extends FragmentActivity {
    RadioButton homePage,//底部的三个按钮
            shop,
            me;
     ImageView       search,shoppingCar,//首页顶部按钮
            setting_me,shopping_car_me,//我的页面的顶部
            shopping_car_shop,search_goods_shop;//商铺页面的按钮
    /*ImageView imageviewOvertab;*/
    RelativeLayout relHome,relShop,relMe;
    ViewPager viewPager;
    RadioGroup group;
    HomePageFragment homePageFragment;
    ShopShowFragment shopShowFragment;
    MePageFragment mePageFragment;
    GestureDetector mGestureDetector;
    List<Fragment> fragmentList;
    int screenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_ht);


        fragmentList=new ArrayList<Fragment>();
        screenWidth=getResources().getDisplayMetrics().widthPixels;
        viewPager= (ViewPager) findViewById(R.id.container);

        homePageFragment = new HomePageFragment();
        shopShowFragment = new ShopShowFragment();
        mePageFragment = new MePageFragment();
        fragmentList.add(homePageFragment);
        fragmentList.add(shopShowFragment);
        fragmentList.add(mePageFragment);
        //viewpager 设置适配器
        viewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
        //显示当前视图为第一个fragment
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        homePage.setChecked(true);
                        break;
                    case 1:
                        shop.setChecked(true);
                        break;
                    case 2:
                        me.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Animation animation = new TranslateAnimation(0,0,0,0);//平移动画
                animation.setFillAfter(true);//动画终止时停留在最后一帧，不然会回到没有执行前的状态
                animation.setDuration(200);//动画持续时间0.2秒
               /* int i = currIndex + 1;image.startAnimation(animation);//是用ImageView来显示动画的*/

                /*Toast.makeText(MyHomePageActivity.this, "您选择了第2个页卡", Toast.LENGTH_SHORT).show();*/

            }
        });
      /*  mGestureDetector = new GestureDetector(this, gestureDetector);*/


        homePage = (RadioButton) findViewById(R.id.home);
        /*二级界面三个页面的显示*/
        shop = (RadioButton) findViewById(R.id.shop);
        me = (RadioButton) findViewById(R.id.user);
        group = (RadioGroup) findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home:
                        relHome.setVisibility(View.VISIBLE);
                        relShop.setVisibility(View.GONE);
                        relMe.setVisibility(View.GONE);
                        changeView(0);
                        break;
                    case R.id.shop:
                        relHome.setVisibility(View.GONE);
                        relShop.setVisibility(View.VISIBLE);
                        relMe.setVisibility(View.GONE);
                        changeView(1);
                        break;
                    case R.id.user:
                        relHome.setVisibility(View.GONE);
                        relShop.setVisibility(View.GONE);
                        relMe.setVisibility(View.VISIBLE);
                        changeView(2);
                        break;
                }
            }
        });
        //三个顶部布局
        relHome= (RelativeLayout) findViewById(R.id.rel_home);
        relShop= (RelativeLayout) findViewById(R.id.rel_shop);
        relMe= (RelativeLayout) findViewById(R.id.rel_me);
        //home顶部
        search= (ImageView) findViewById(R.id.search_home);
        shoppingCar= (ImageView) findViewById(R.id.shopping_car_home);
        //搜索跳转
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyHomePageActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        //购物车跳转
        shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyHomePageActivity.this, MyShoppingcartchoose.class);
                startActivity(intent);
            }
        });


        //shop顶部
        shopping_car_shop= (ImageView) findViewById(R.id.shopping_car_shop);
        search_goods_shop= (ImageView) findViewById(R.id.search_goods_shop);
        shopping_car_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //跳转购物车  需要bundle数据？？
                Intent intent=new Intent(MyHomePageActivity.this,MyShoppingcartchoose.class);
                startActivity(intent);
            }
        });
        search_goods_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到搜索界面 需要bundle数据？？
                Intent intent=new Intent(MyHomePageActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        //我的顶部
        setting_me= (ImageView) findViewById(R.id.setting_me);
        shopping_car_me= (ImageView) findViewById(R.id.shopping_car_me);
        setting_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人设置界面 需要bundle数据？？
                Intent intent=new Intent(MyHomePageActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
        shopping_car_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转购物车  需要bundle数据？？
                Intent intent=new Intent(MyHomePageActivity.this,MyShoppingcartchoose.class);
                startActivity(intent);
            }
        });

    }


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
                viewPager.setCurrentItem(0);
            } else if (e2.getX() - e1.getX() > 20 && Math.abs(velocityX) > velocityY) {

            }
            return false;
        }
    };

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }*/
    int currentTab=-1;
   class HomePagerAdapter extends FragmentStatePagerAdapter {


        public HomePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

       @Override
       public void notifyDataSetChanged() {
           super.notifyDataSetChanged();
       }

       @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);//这句话要放在最前面，否则会报错
            //获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置
            int currentItem=viewPager.getCurrentItem();
            if(currentItem==currentTab){
                return;
            }
            moveFragment(viewPager.getCurrentItem());
            currentTab=viewPager.getCurrentItem();

        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
    }
    private void moveFragment(int moveToTab){
        int startPosition=0;
        int moveToPosition=0;
        startPosition=currentTab*(screenWidth/4);
        moveToPosition=moveToTab*(screenWidth/4);
        TranslateAnimation ta=new TranslateAnimation(startPosition,moveToPosition,0,0);
        ta.setFillAfter(true);
        ta.setDuration(200);
        /*imageviewOvertab.startAnimation(ta);*/
    }
    /**
     * 手动设置viewpager想要显示的视图
     * */
    private void changeView(int desTab){
        viewPager.setCurrentItem(desTab,true);
    }

}
