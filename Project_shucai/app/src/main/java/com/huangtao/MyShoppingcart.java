package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.along.ui1project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */
public class MyShoppingcart extends Activity {
    ImageView imageView;
    ImageView imageView1;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gwoc);

        listView = (ListView) findViewById(R.id.activity_shoppingcart_choose);
        getData();
        String[] from = {"tup", "cpmc", "jiage"};
        int[] to = {R.id.tup, R.id.cpmc, R.id.jiage};
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MyShoppingcart.this,
                list,
                R.layout.activity_shoppingcart_ht,
                from,
                to);
        listView.setAdapter(simpleAdapter);

        imageView= (ImageView) findViewById(R.id.jiaqu);
        imageView1= (ImageView) findViewById(R.id.jias);
//        imageView.setOnClickListener(onClikListener);
//        imageView1.setOnClickListener(onClikListener);

    }
//    View.OnClickListener onClikListener=new View.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//                case R.id.jiaqu:
//                    break;
//                case R.id.jias:
//                    break;
//            }
//        }
//    };
    List<HashMap<String, Object>> list;
    public List<HashMap<String, Object>> getData() {
        list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("tup", R.mipmap.dojiatu);
            map.put("cpmc", "阿青家有机豌豆");
            map.put("jiage", "28.80/斤");
            list.add(map);
        }
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("tup", R.mipmap.huactu);
            map.put("cpmc", "阿青家有机花菜");
            map.put("jiage", "9.80/斤");
            list.add(map);
        }
        return list;
    }



}
