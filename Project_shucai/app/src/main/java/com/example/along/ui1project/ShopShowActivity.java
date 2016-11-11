package com.example.along.ui1project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 2016/11/8.
 */
public class ShopShowActivity extends Activity {
    TextView search,shoppingCar;
    RadioButton allSort,organicVegetable,currentOrganicVegetable,farmNative;
    ListView goodsList;
    Context context=ShopShowActivity.this;
    List<ShopItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_shop_layout);
        search= (TextView) findViewById(R.id.search_goods);
        shoppingCar= (TextView) findViewById(R.id.shopping_car);
        allSort= (RadioButton) findViewById(R.id.all_sort);
        organicVegetable= (RadioButton) findViewById(R.id.organic_vegetable);
        currentOrganicVegetable= (RadioButton) findViewById(R.id.current_organic_vegetable);
        farmNative= (RadioButton) findViewById(R.id.farm_native);
        goodsList= (ListView) findViewById(R.id.shop_goods_show);

        list=new ArrayList<ShopItem>();
        getAllData();
        goodsList.setAdapter(new ShopShowAdapter(list,R.layout.shop_list_item,context));


        search.setOnClickListener(onClickListener);
        shoppingCar.setOnClickListener(onClickListener);
        allSort.setOnClickListener(onClickListener);
        organicVegetable.setOnClickListener(onClickListener);
        currentOrganicVegetable.setOnClickListener(onClickListener);
        farmNative.setOnClickListener(onClickListener);
        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"现在点击的是"+position+" 即将跳转 做好准备",Toast.LENGTH_SHORT).show();
            }
        });
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.search_goods:
                    break;
                case R.id.shopping_car:
                    break;
                case R.id.all_sort:
                    list=new ArrayList<ShopItem>();
                    getAllData();
                    goodsList.setAdapter(new ShopShowAdapter(list,R.layout.shop_list_item,context));
                    break;
                case R.id.organic_vegetable:
                    List<ShopItem> organic_list=new ArrayList<>();
                    organic_list=list.subList(2,4);
                    goodsList.setAdapter(new ShopShowAdapter(organic_list,R.layout.shop_list_item,context));
                    break;
                case R.id.current_organic_vegetable:
                    List<ShopItem> current_list=new ArrayList<>();
                    current_list=list.subList(3,4);
                    goodsList.setAdapter(new ShopShowAdapter(current_list,R.layout.shop_list_item,context));
                    break;
                case R.id.farm_native:
                    List<ShopItem> native_list=new ArrayList<>();
                    native_list=list.subList(0,1);
                    goodsList.setAdapter(new ShopShowAdapter(native_list,R.layout.shop_list_item,context));
                    break;
                case R.id.shop_goods_show:
                    break;
            }
        }
    };
    public void getAllData(){
        int[] imgs=new int[]{R.mipmap.native_eggs,R.mipmap.copop,R.mipmap.green_bean,R.mipmap.flower_vegetable,
        R.mipmap.marshroom};
        String[] titles={"农家土鸡蛋","有机胡萝卜","有机豌豆","有机花椰菜","有机香菇"};
        String[] prices={"32.8/","16.8/","16.8/","15.8/","12.8/"};
        String[] units={"15枚","500g","500g","1个","200g"};

        for(int i=0;i<5;i++){
            ShopItem item=new ShopItem();
            item.setImg(imgs[i]);
            item.setTitle(titles[i]);
            item.setSubTitle("有机纯天然，不含任何化学添加剂");
            item.setPrice(prices[i]);
            item.setUnit(units[i]);
            list.add(item);
        }
    }
}
