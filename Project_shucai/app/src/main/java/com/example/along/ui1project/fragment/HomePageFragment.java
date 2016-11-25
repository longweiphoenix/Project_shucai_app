package com.example.along.ui1project.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.along.ui1project.R;

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment {
    ImageView shoppingCar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_page_layout,null);
        //跳转到购物车
        shoppingCar= (ImageView) view.findViewById(R.id.shopping_car);
        shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),);
                startActivity(intent);
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
