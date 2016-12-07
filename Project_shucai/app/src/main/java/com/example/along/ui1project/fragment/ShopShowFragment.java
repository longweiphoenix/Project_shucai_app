package com.example.along.ui1project.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.along.ui1project.adpaters.ShopShowAdapter;
import com.example.along.ui1project.objects.ShopItem;
import com.example.first.project.GoodsDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ShopShowFragment extends android.support.v4.app.Fragment {

    RadioButton allSort, organicVegetable, currentOrganicVegetable, farmNative;
    ListView goodsList;
    List<ShopItem> list;
    LayoutInflater layoutInflater;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("onCreateView","onCreateView");
        layoutInflater=inflater;
        View view = inflater.inflate(R.layout.all_shop_layout, null);

        allSort = (RadioButton) view.findViewById(R.id.all_sort);
        organicVegetable = (RadioButton) view.findViewById(R.id.organic_vegetable);
        currentOrganicVegetable = (RadioButton) view.findViewById(R.id.current_organic_vegetable);
        farmNative = (RadioButton) view.findViewById(R.id.farm_native);
        goodsList = (ListView) view.findViewById(R.id.shop_goods_show);
        list=new ArrayList<ShopItem>();
        getAllData();
        goodsList.setAdapter(new ShopShowAdapter(list, R.layout.shop_list_item, getActivity(),layoutInflater));

        allSort.setOnClickListener(onClickListener);
        organicVegetable.setOnClickListener(onClickListener);
        currentOrganicVegetable.setOnClickListener(onClickListener);
        farmNative.setOnClickListener(onClickListener);
        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //activity间的进行图片传值
                ShopItem item = (ShopItem) parent.getItemAtPosition(position);

                Intent intent=new Intent(getActivity(), GoodsDetailsActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });
        /*setListViewHeightBasedOnChildren(goodsList);*/
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate","onCreate");
        super.onCreate(savedInstanceState);

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
                case R.id.all_sort:
                    allSort.setTextColor(getResources().getColor(R.color.selected_text));
                    organicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    currentOrganicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    farmNative.setTextColor(getResources().getColor(R.color.title_font_color));
                    list = new ArrayList<ShopItem>();
                    getAllData();
                    for(int i=0;i<list.size();i++){
                        String str=list.get(i).getTitle();
                        Log.i("list",str);
                    }
                    goodsList.setAdapter(new ShopShowAdapter(list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.organic_vegetable:
                    allSort.setTextColor(getResources().getColor(R.color.title_font_color));
                    organicVegetable.setTextColor(getResources().getColor(R.color.selected_text));
                    currentOrganicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    farmNative.setTextColor(getResources().getColor(R.color.title_font_color));
                    List<ShopItem> organic_list = new ArrayList<>();
                    organic_list = list.subList(2, 4);
                    goodsList.setAdapter(new ShopShowAdapter(organic_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.current_organic_vegetable:
                    allSort.setTextColor(getResources().getColor(R.color.title_font_color));
                    organicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    currentOrganicVegetable.setTextColor(getResources().getColor(R.color.selected_text));
                    farmNative.setTextColor(getResources().getColor(R.color.title_font_color));
                    List<ShopItem> current_list = new ArrayList<>();
                    current_list = list.subList(3, 4);
                    goodsList.setAdapter(new ShopShowAdapter(current_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.farm_native:
                    allSort.setTextColor(getResources().getColor(R.color.title_font_color));
                    organicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    currentOrganicVegetable.setTextColor(getResources().getColor(R.color.title_font_color));
                    farmNative.setTextColor(getResources().getColor(R.color.selected_text));
                    List<ShopItem> native_list = new ArrayList<>();
                    native_list = list.subList(0, 1);
                    goodsList.setAdapter(new ShopShowAdapter(native_list, R.layout.shop_list_item, getActivity(),layoutInflater));
                    break;
                case R.id.shop_goods_show:
                    break;
            }
        }


    };
    /*public void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }*/
}
