package com.example.along.ui1project.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.along.ui1project.R;
import com.example.along.ui1project.adpaters.MeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/11/10.
 */
public class MePageFragment extends android.support.v4.app.Fragment {
    ListView myList;
    List<HashMap<String, Object>> list;
    LayoutInflater layoutInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_page, container, false);
        //我的页面列表
        myList = (ListView) view.findViewById(R.id.home_list_view);
        layoutInflater = LayoutInflater.from(getActivity());
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        setListView();
        setListViewHeightBasedOnChildren(myList);
        return view;
    }

    public void setListView() {
        list = new ArrayList<>();
        getData();
        myList.setAdapter(new MeAdapter(getActivity(), list,layoutInflater));
        /*View view = layoutInflater.inflate(R.layout.home_list_view_footer, null);
        view.setLayoutParams(new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        homePage= (TextView) view.findViewById(R.id.home);
        shop_green= (TextView) view.findViewById(R.id.shop_green);
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
    public void setListViewHeightBasedOnChildren(ListView listView) {
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
    }
}
