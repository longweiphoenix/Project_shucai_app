package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.along.ui1project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MyShoppingcartchoose extends Activity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodegwucbji);


        listView = (ListView) findViewById(R.id.activity_shoppingcart_payment);
        getData();
        String[] from = {"cqutu", "cpmz", "cdejiage"};
        int[] to = {R.id.cqutu, R.id.cpmz, R.id.cdejiage};
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MyShoppingcartchoose.this,
                list,
                R.layout.activity_shoppingcart_choose_ht,
                from,
                to);
        listView.setAdapter(simpleAdapter);
    }


    List<HashMap<String, Object>> list;
    public List<HashMap<String, Object>> getData() {
        list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("cqutu", R.mipmap.dojiatu);
            map.put("cpmz", "阿青家有机豌豆");
            map.put("cdejiage", "28.80/斤");
            list.add(map);
        }
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("cqutu", R.mipmap.huactu);
            map.put("cpmz", "阿青家有机花菜");
            map.put("cdejiage", "9.80/斤");
            list.add(map);
        }
        return list;
    }
}
