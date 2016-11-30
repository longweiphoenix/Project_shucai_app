package com.example.along.ui1project.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.zxy.HealthyMenuOneActivity;


/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment {
   TextView textView;
   @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_home_page2_ht,null);
        //跳转到购物车
        textView= (TextView) view.findViewById(R.id.healthy_menu);
        return view;

   }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        textView.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            public void onClick(View v) {
                intent=new Intent(getActivity(),HealthyMenuOneActivity.class);
                startActivity(intent);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
