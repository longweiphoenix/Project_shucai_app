package com.example.along.ui1project;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.example.along.ui1project.fragment.MeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Long on 2016/10/25.
 */
public class PersonalSetting extends Activity {
    ListView personalSettingListView;
    List<HashMap<String,Object>> list;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater=LayoutInflater.from(this);
        setContentView(R.layout.personal_setting);//个人设置布局文件
        personalSettingListView= (ListView) findViewById(R.id.personal_setting_list_view);//个人设置
        list=new ArrayList<HashMap<String, Object>>();
        getItemData();
        personalSettingListView.setAdapter(new MeAdapter(PersonalSetting.this,list,inflater));
    }

    public void getItemData(){
        String[] personalList=getResources().getStringArray(R.array.personal_list_view);
        Integer[] personalListImg=new Integer[]{R.mipmap.picture_quality,R.mipmap.clear_cache
        ,R.mipmap.feed_back,R.mipmap.about_us,R.mipmap.support_us,R.mipmap.logout};
        for (int i=0;i<personalList.length;i++){
            HashMap<String,Object> map=new HashMap<>();
            map.put("list_text",personalList[i]);
            map.put("list_img",personalListImg[i]);
            list.add(map);
        }
    }
}
