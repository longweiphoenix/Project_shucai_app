package com.huangtao.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.along.ui1project.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyDarFragmentList extends Fragment {

    ListView listView;
    ArrayList<ItemData> list;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview,null);
        listView = (ListView) view.findViewById(R.id.list_item);
        getData();
        context = getActivity();
        ListAdapter listAdapter = new ListAdapter(context,list);
        listView.setAdapter(listAdapter);
        return view;
    }
    public void getData(){
        list = new ArrayList<ItemData>();
        for (int i = 0; i < 5; i++){
            ItemData itemData = new ItemData();
            itemData.setImage(R.mipmap.head_portrait);
            itemData.setName("氧气");
            itemData.setDynamicState(33);
            itemData.setFans(23);
            list.add(itemData);
        }
    }
}
