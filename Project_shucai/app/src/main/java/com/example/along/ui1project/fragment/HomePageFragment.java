package com.example.along.ui1project.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.along.ui1project.SearchActivity;
import com.huangtao.ShoppingCarActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_home_page2_ht,null);
        return view;
    }
}
