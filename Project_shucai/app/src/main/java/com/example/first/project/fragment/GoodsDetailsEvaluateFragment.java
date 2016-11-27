package com.example.first.project.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.along.ui1project.R;
import com.example.first.project.adapter.GoodsCommentAdapter;
import com.example.first.project.needdata.GoodsComment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/0012.
 */

public class GoodsDetailsEvaluateFragment extends Fragment {
    ListView listView;
    ArrayList<GoodsComment> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goods_details_evaluate,null);
        listView = (ListView) view.findViewById(R.id.comment_list);
        GoodsCommentAdapter goodsCommentAdapter = new GoodsCommentAdapter(view.getContext(),list);
        listView.setAdapter(goodsCommentAdapter);
        return view;
    }

}
