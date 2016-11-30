package com.example.along.ui1project.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.zxy.HealthyMenuOneActivity;


/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment {
    TextView textView;
    LinearLayout fatherView, fatherViewLife;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page2_ht, null);
        //跳转到购物车
        textView = (TextView) view.findViewById(R.id.healthy_menu);
        fatherView = (LinearLayout) view.findViewById(R.id.father_view);
        fatherViewLife = (LinearLayout) view.findViewById(R.id.father_view_life);
        for (int i = 0; i < 5; i++) {
            View childview = inflater.inflate(R.layout.gallery_item, null);
            View lifeChild = inflater.inflate(R.layout.gallery_item, null);
            ImageView ofChildView = (ImageView) lifeChild.findViewById(R.id.gallery_item);
            ofChildView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "btn", Toast.LENGTH_SHORT).show();
                }
            });
            fatherView.addView(childview);
            fatherViewLife.addView(lifeChild);
        }
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        textView.setOnClickListener(new View.OnClickListener() {
            Intent intent;

            public void onClick(View v) {
                intent = new Intent(getActivity(), HealthyMenuOneActivity.class);
                startActivity(intent);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
