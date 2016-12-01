package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.example.zxy.Adapter.CookingParepreAdapter;
import com.example.zxy.Adapter.CookingProcessAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 */
public class CookingActivity extends Activity {
    ListView listView;//制作准备的listView
    ListView newListView;//制作过程的listView
    List<HashMap<String,Object>> list;
    List<HashMap<String,Object>> newList;
     LayoutInflater layoutInflater;
    TextView parepre,
             process;
              //返回箭头         //收藏
    ImageView menuArowImageView,menuHeartImageView;
    boolean isFavorite=true;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_prepare);

        parepre = (TextView) findViewById(R.id.parepre_button);
        process = (TextView) findViewById(R.id.process_button);
        listView= (ListView) findViewById(R.id.menu_parepre_listview);
        newListView= (ListView) findViewById(R.id.menu_process_listview);
        menuHeartImageView= (ImageView) findViewById(R.id.menu_heart_imageView);
        menuArowImageView = (ImageView) findViewById(R.id.menu_arow_imageview);
        //使一进去页面在最上面
        newListView.setFocusable(false);
        listView.setFocusable(false);

        menuArowImageView.setOnClickListener(listener);
        parepre.setOnClickListener(listener);
        process.setOnClickListener(listener);

        layoutInflater=LayoutInflater.from(this);
        list=new ArrayList<>();
        newList=new ArrayList<>();
        getParepreDate();
        getProcessDate();
        listView.setAdapter(new CookingParepreAdapter(this,list));
        newListView.setAdapter(new CookingProcessAdapter(this,newList));

        //是否收藏
        menuHeartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFavorite){
                    Toast.makeText(CookingActivity.this,"收藏成功！",Toast.LENGTH_SHORT).show();
                    menuHeartImageView.setImageResource(R.mipmap.heart_green);
                    isFavorite=false;
                }else{
                    Toast.makeText(CookingActivity.this,"取消收藏成功！",Toast.LENGTH_SHORT).show();
                    menuHeartImageView.setImageResource(R.mipmap.heart_white);
                    isFavorite=true;
                }
            }
        });

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
                   newListView.setVisibility(View.GONE);
                   listView.setVisibility(View.VISIBLE);
                   break;
               case R.id.process_button:
                   process.setTextColor(getResources().getColor(R.color.fontgreen));
                   parepre.setTextColor(getResources().getColor(R.color.fontblack1));
                   listView.setVisibility(View.GONE);
                   newListView.setVisibility(View.VISIBLE);
                   break;
               case R.id.menu_arow_imageview:
                   intent=new Intent(CookingActivity.this,HealthyMenuOneActivity.class);
                   startActivity(intent);
                   break;
           }
        }
    };
    public void getParepreDate(){
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
    public void getProcessDate(){
      Integer[] image = new Integer[]{R.mipmap.process1,R.mipmap.process2,R.mipmap.process3,R.mipmap.process4,R.mipmap.process5,
      R.mipmap.process6,R.mipmap.process7,R.mipmap.process8};
        String[] number =getResources().getStringArray(R.array.menu_process_number);
        String[] process=getResources().getStringArray(R.array.menu_process);
        for (int i =0;i<image.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("number",number[i]);
            map.put("process",process[i]);
            map.put("image",image[i]);
            newList.add(map);
        }
    }
}
