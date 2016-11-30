package com.example.along.ui1project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Long on 2016/12/1.
 */
public class MyTopicksActivity extends Activity {
    ListView topics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_topics_activity);
        topics= (ListView) findViewById(R.id.topics_list_view);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
