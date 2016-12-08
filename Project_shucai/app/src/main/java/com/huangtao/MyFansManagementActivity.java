package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.along.ui1project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/11/30.
 */
public class MyFansManagementActivity extends Activity {
    ImageButton imageButton;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans_ht);

        imageButton= (ImageButton) findViewById(R.id.fesdefah);
        listView= (ListView) findViewById(R.id.feslistview);

        imageButton.setOnClickListener(onClickListener);

        getData();
        String[] from = {"festox", "fesmz", "fesdot", "fesfes"};
        int[] to = {R.id.festox, R.id.fesmz, R.id.fesdot, R.id.fesfes};
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MyFansManagementActivity.this,
                list,
                R.layout.feslero,
                from,
                to);
        listView.setAdapter(simpleAdapter);
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fesdefah:
                    finish();
                    break;
            }
        }
    };
    List<HashMap<String, Object>> list;
    public List<HashMap<String, Object>> getData() {
        list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 1; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("festox", R.mipmap.head_portrait);
            map.put("fesmz", "氧气");
            map.put("fesdot", "34动态");
            map.put("fesfes", "302粉丝");
            list.add(map);
        }
        for (int i = 0; i < 1; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("festox", R.mipmap.head_portrait);
            map.put("fesmz", "空气");
            map.put("fesdot", "动态");
            map.put("fesfes", "粉丝");
            list.add(map);
        }

        return list;
    }
}
