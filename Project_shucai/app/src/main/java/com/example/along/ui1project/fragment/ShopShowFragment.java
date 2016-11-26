package com.example.along.ui1project.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.along.ui1project.ShopItem;
import com.example.along.ui1project.ShopShowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ShopShowFragment extends Fragment {
    TextView search, shoppingCar;
    RadioButton allSort, organicVegetable, currentOrganicVegetable, farmNative;
    ListView goodsList;
    List<ShopItem> list;
    LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater=inflater;
        View view = inflater.inflate(R.layout.all_shop_layout, null);
        search = (TextView) view.findViewById(R.id.search_goods);
        shoppingCar = (TextView) view.findViewById(R.id.shopping_car);
        allSort = (RadioButton) view.findViewById(R.id.all_sort);
        organicVegetable = (RadioButton) view.findViewById(R.id.organic_vegetable);
        currentOrganicVegetable = (RadioButton) view.findViewById(R.id.current_organic_vegetable);
        farmNative = (RadioButton) view.findViewById(R.id.farm_native);
        goodsList = (ListView) view.findViewById(R.id.shop_goods_show);

        list = new ArrayList<ShopItem>();
        getAllData();
        goodsList.setAdapter(new ShopShowAdapter(list, R.layout.shop_list_item, getActivity(),inflater));


        search.setOnClickListener(onClickListener);
        shoppingCar.setOnClickListener(onClickListener);
        allSort.setOnClickListener(onClickListener);
        organicVegetable.setOnClickListener(onClickListener);
        currentOrganicVegetable.setOnClickListener(onClickListener);
        farmNative.setOnClickListener(onClickListener);
        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "现在点击的是" + position + " 即将跳转 做好准备", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    public void getAllData() {
        int[] imgs = new int[]{R.mipmap.native_eggs, R.mipmap.copop, R.mipmap.green_bean, R.mipmap.flower_vegetable,
                R.mipmap.marshroom};
        String[] titles = {"农家土鸡蛋", "有机胡萝卜", "有机豌豆", "有机花椰菜", "有机香菇"};
        String[] prices = {"32.8/", "16.8/", "16.8/", "15.8/", "12.8/"};
        String[] units = {"15枚", "500g", "500g", "1个", "200g"};

        for (int i = 0; i < 5; i++) {
            ShopItem item = new ShopItem();
            item.setImg(imgs[i]);
            item.setTitle(titles[i]);
            item.setSubTitle("有机纯天然，不含任何化学添加剂");
            item.setPrice(prices[i]);
            item.setUnit(units[i]);
            list.add(item);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search_goods:
                    break;
                case R.id.shopping_car:
                    break;
                case R.id.all_sort:
                    list = new ArrayList<ShopItem>();
                    getAllData();
                    goodsList.setAdapter(new ShopShowAdapter(list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.organic_vegetable:
                    List<ShopItem> organic_list = new ArrayList<>();
                    organic_list = list.subList(2, 4);
                    goodsList.setAdapter(new ShopShowAdapter(organic_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.current_organic_vegetable:
                    List<ShopItem> current_list = new ArrayList<>();
                    current_list = list.subList(3, 4);
                    goodsList.setAdapter(new ShopShowAdapter(current_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.farm_native:
                    List<ShopItem> native_list = new ArrayList<>();
                    native_list = list.subList(0, 1);
                    goodsList.setAdapter(new ShopShowAdapter(native_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.shop_goods_show:
                    break;
            }
        }


    };
}
