package com.example.along.ui1project.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.along.ui1project.MyFavoriteManageActivity;
import com.example.along.ui1project.MyTopicksActivity;
import com.example.along.ui1project.R;
import com.example.along.ui1project.adpaters.MeAdapter;
import com.example.first.project.MyFoodActivity;
import com.example.first.project.YiHomeActivity;
import com.example.first.project.CustomerServiceActivity;
import com.huangtao.MyConcernActivity;
import com.huangtao.MyFansManagementActivity;

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

    TextView watch,fans;
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

        watch= (TextView) view.findViewById(R.id.watch);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyConcernActivity.class);
                startActivity(intent);
            }
        });
        fans= (TextView) view.findViewById(R.id.fans);
        fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyFansManagementActivity.class);
                startActivity(intent);
            }
        });
        layoutInflater = LayoutInflater.from(getActivity());
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent=new Intent(getActivity(), YiHomeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getActivity(), MyFoodActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(getActivity(), MyFavoriteManageActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(getActivity(), MyTopicksActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent=new Intent(getActivity(), YiHomeActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent=new Intent(getActivity(), CustomerServiceActivity.class);
                        startActivity(intent);
                        break;
                }
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
        homePage= (TextView) view.findViewById(R.id.home_black);
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
