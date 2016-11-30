package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.along.ui1project.MyHomePageActivity;
import com.example.along.ui1project.R;
import com.example.first.project.adapter.OrganicLifeAdapter;
import com.example.first.project.needdata.OrganicLife;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/0011.
 */

public class OrganicLifeActivity extends Activity {

    ImageView back; //返回上级
    ListView organicLife;

    ArrayList<OrganicLife> lifes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organic_life);

        back = (ImageView) findViewById(R.id.back);
        organicLife = (ListView) findViewById(R.id.organic_life);
        getData();
        OrganicLifeAdapter organicLifeAdapter = new OrganicLifeAdapter(OrganicLifeActivity.this,lifes);
        organicLife.setAdapter(organicLifeAdapter);
        //点击加载显示详情页面
        organicLife.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                final TextView textView = (TextView) view.findViewById(R.id.title);

               imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(OrganicLifeActivity.this, SubOrganicLifeActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putString("title",textView.getText().toString().trim());
                       bundle.putString("url","file:///android_asset/Untitled-1.html");
                       intent.putExtras(bundle);
                       startActivity(intent);
                   }
               });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrganicLifeActivity.this, MyHomePageActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getData(){
        lifes = new ArrayList<OrganicLife>();

        OrganicLife organicLife1 = new OrganicLife();
        organicLife1.setTitle("冬日上火，三招解决");
        organicLife1.setImage(R.mipmap.organic_life_one);
        organicLife1.setLoveNumb(166);
        organicLife1.setSeeNumb(166);
        lifes.add(organicLife1);

        OrganicLife organicLife2 = new OrganicLife();
        organicLife2.setTitle("专家告诉你如何合理搭配饮食");
        organicLife2.setImage(R.mipmap.organic_life_two);
        organicLife2.setLoveNumb(166);
        organicLife2.setSeeNumb(166);
        lifes.add(organicLife2);

        OrganicLife organicLife3 = new OrganicLife();
        organicLife3.setTitle("有机蔬菜与绿色蔬菜、无公害蔬菜的区别");
        organicLife3.setImage(R.mipmap.organic_life_three);
        organicLife3.setLoveNumb(166);
        organicLife3.setSeeNumb(166);
        lifes.add(organicLife3);

    }


}
