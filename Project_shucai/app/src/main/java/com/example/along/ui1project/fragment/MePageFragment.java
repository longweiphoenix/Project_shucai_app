package com.example.along.ui1project.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.along.ui1project.PersonalInfo;
import com.example.along.ui1project.R;
import com.huangtao.ShoppingCarActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/11/10.
 */
public class MePageFragment extends Fragment {
    ListView myList;
    List<HashMap<String, Object>> list;
    LayoutInflater layoutInflater;
    TextView shoppingCar,
             setting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_page, container, false);
        shoppingCar= (TextView) view.findViewById(R.id.shopping_car);
        setting= (TextView) view.findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PersonalInfo.class);
                startActivity(intent);
            }
        });
        shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ShoppingCarActivity.class);
                startActivity(intent);
            }
        });
        //我的页面列表
        myList = (ListView) view.findViewById(R.id.home_list_view);
        layoutInflater = LayoutInflater.from(getActivity());
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        setListView();
        return view;
    }

    public void setListView() {
        list = new ArrayList<>();
        getData();
        myList.setAdapter(new MeAdapter(getActivity(), list,layoutInflater));
        /*View view = layoutInflater.inflate(R.layout.home_list_view_footer, null);
        view.setLayoutParams(new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        homePage= (TextView) view.findViewById(R.id.home);
        shop= (TextView) view.findViewById(R.id.shop);
        me= (TextView) findViewById(R.id.user);
        myList.addFooterView(view);*/
    }

    public void getData() {
        String[] myText = getResources().getStringArray(R.array.myListText);
        Integer[] img = new Integer[]{R.mipmap.my_order, R.mipmap.food_stamps, R.mipmap.my_collections,
                R.mipmap.my_collections, R.mipmap.address_manager, R.mipmap.customer_service
        };
        for (int i = 0; i < myText.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("list_text", myText[i]);
            map.put("list_img", img[i]);
            list.add(map);
        }
    }
}
