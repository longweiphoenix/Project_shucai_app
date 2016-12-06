package com.example.along.ui1project.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.along.ui1project.callback.TransmitFragmentData;
import com.example.first.project.OrganicLifeActivity;
import com.example.zxy.HealthyMenuOneActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2016/11/25.
 */
public class HomePageFragment extends Fragment implements TransmitFragmentData {
    TextView healthMenu, organicLifeInner, natives;
    LinearLayout fatherView, fatherViewLife;
    LayoutInflater layoutInflater;
    List<HashMap<String, Object>> datas;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datas = new ArrayList<>();
    }
    List<Bitmap> bitmaps;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page2_ht, null);
        //跳转到购物车
        organicLifeInner = (TextView) view.findViewById(R.id.organic_life_inner);
        organicLifeInner.setOnClickListener(onClickListener);
        natives = (TextView) view.findViewById(R.id.farm_native);
        natives.setOnClickListener(onClickListener);
        healthMenu = (TextView) view.findViewById(R.id.healthy_menu);
        healthMenu.setOnClickListener(onClickListener);
        fatherView = (LinearLayout) view.findViewById(R.id.father_view);
        fatherViewLife = (LinearLayout) view.findViewById(R.id.father_view_life);
        layoutInflater = inflater;
        if(bitmaps!=null){
            for (int i = 0; i < bitmaps.size(); i++) {
                View childview = layoutInflater.inflate(R.layout.gallery_item, null);
                View lifeChild = layoutInflater.inflate(R.layout.gallery_item, null);
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
        }
        return view;
    }

    Intent intent;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.farm_native:
                    FragmentManager manager=getActivity().getSupportFragmentManager();
                    break;
                case R.id.organic_life_inner:
                    intent = new Intent(getActivity(), OrganicLifeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.healthy_menu:
                    intent = new Intent(getActivity(), HealthyMenuOneActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        healthMenu.setOnClickListener(new View.OnClickListener() {
            Intent intent;

            public void onClick(View v) {
                intent = new Intent(getActivity(), HealthyMenuOneActivity.class);
                startActivity(intent);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    //定义接口
    /*public interface OnButtonClick {
        public void onClick(View view);
    }

    private OnButtonClick onButtonClick;

    //定义接口变量的get方法
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    //定义接口变量的set方法
    public void setOnButtonClick() {

    }*/


    @Override
    public void transimitData(List<Bitmap> bitmaps) {
        this.bitmaps=bitmaps;
    }
}
