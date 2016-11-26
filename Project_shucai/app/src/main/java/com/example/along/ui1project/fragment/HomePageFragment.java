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

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment {
    TextView shoppingCar,search;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_page_layout,null);
        //跳转到购物车
        shoppingCar= (TextView) view.findViewById(R.id.shopping_car);
        search= (TextView) view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });
        shoppingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(getActivity(),);
               // startActivity(intent);
                Toast.makeText(getActivity(),"电击Fragment",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
