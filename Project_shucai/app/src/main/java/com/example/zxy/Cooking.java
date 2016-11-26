package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.example.zxy.Adapter.CookingAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/10/30.
 */
public class Cooking extends Activity {
    ListView listView;
    List<HashMap<String,Object>> list;
    LayoutInflater layoutInflater;
    TextView parepre,
             process;
    LinearLayout menuParepre,
                  menuProcess;
    ImageView menuArowImageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_prepare);
        parepre = (TextView) findViewById(R.id.parepre_button);
        process = (TextView) findViewById(R.id.process_button);
        menuParepre = (LinearLayout) findViewById(R.id.menu_parepre_linearlayout);
        menuProcess= (LinearLayout) findViewById(R.id.menu_process_linearlayout);
        menuArowImageView = (ImageView) findViewById(R.id.menu_arow_imageview);
        menuArowImageView.setOnClickListener(listener);
        parepre.setOnClickListener(listener);
        process.setOnClickListener(listener);
        layoutInflater=LayoutInflater.from(this);
        list=new ArrayList<>();
        getDate();
        listView.setAdapter(new CookingAdapter(this,list));

    }
    //做菜流程和准备的点击切换
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
           switch (v.getId()){
               case R.id.parepre_button:
                   parepre.setTextColor(getResources().getColor(R.color.fontgreen));
                   process.setTextColor(getResources().getColor(R.color.fontblack1));
                   menuProcess.setVisibility(View.GONE);
                   menuParepre.setVisibility(View.VISIBLE);
                   break;
               case R.id.process_button:
                   process.setTextColor(getResources().getColor(R.color.fontgreen));
                   parepre.setTextColor(getResources().getColor(R.color.fontblack1));
                   menuParepre.setVisibility(View.GONE);
                   menuProcess.setVisibility(View.VISIBLE);
                   break;
               case R.id.menu_arow_imageview:
                   intent=new Intent(Cooking.this,HealthyMenuOne.class);
                   startActivity(intent);
                   break;
           }
        }
    };
    public void getDate(){
        String[] materialOne=getResources().getStringArray(R.array.menu_parepre_one);
        String[] materialTwo=getResources().getStringArray(R.array.menu_parepre_two);
        String[] materialThree=getResources().getStringArray(R.array.menu_parepre_three);
        String[] materialFour=getResources().getStringArray(R.array.menu_parepre_four);
        String[] materialFive=getResources().getStringArray(R.array.menu_parepre_five);
        String[] weightOne=getResources().getStringArray(R.array.menu_parepre_weight_one);
        String[] weightTwo=getResources().getStringArray(R.array.menu_parepre_weight_two);
        String[] weightThree=getResources().getStringArray(R.array.menu_parepre_weight_three);
        String[] weightFout=getResources().getStringArray(R.array.menu_parepre_weight_four);
        String[] weightFive=getResources().getStringArray(R.array.menu_parepre_weight_five);
        Integer[] image =new Integer[]{R.mipmap.prepare1,R.mipmap.prepare2};
        for(int i =0;i<image.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("parepreOne",materialOne[i]);
            map.put("parepreTwo",materialTwo[i]);
            map.put("parepreThree",materialThree[i]);
            map.put("parepreFour",materialFour[i]);
            map.put("parepreFive",materialFive[i]);
            map.put("weightOne",weightOne[i]);
            map.put("weightTwo",weightTwo[i]);
            map.put("weightThree",weightThree[i]);
            map.put("weightFour",weightFout[i]);
            map.put("weightFive",weightFive[i]);
            map.put("image",image[i]);
            list.add(map);
        }

    }
}
