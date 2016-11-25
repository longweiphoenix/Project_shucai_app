package com.example.first.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;

/**订单详情
 * Created by Administrator on 2016/11/0008.
 */

public class YiHomeActivity extends Activity {
    ImageView back; //返回上级页面
    TextView name; //收货人
    TextView linkman; //联系人
    Button commit; //提交

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yi_home);
        findView();

    }
    //找到控件
    public void findView(){
        back = (ImageView) findViewById(R.id.back);
        name = (TextView) findViewById(R.id.name);
        linkman = (TextView) findViewById(R.id.linkman);
        commit = (Button) findViewById(R.id.commit);
    }
}
