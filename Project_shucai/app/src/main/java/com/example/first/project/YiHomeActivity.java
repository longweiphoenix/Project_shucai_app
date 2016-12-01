package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;
import com.huangtao.MyShoppingcartchoose;

/**订单详情
 * Created by Administrator on 2016/11/0008.
 */

public class YiHomeActivity extends Activity {
    ImageView back; //返回上级页面
    TextView name; //收货人
    Button commit; //提交
    ImageView arowRight; //跳转到收货人信息页面
    ImageView shop; //跳转到购物车

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yi_home);
        findView();

        back.setOnClickListener(clickListener);
        commit.setOnClickListener(clickListener);
        shop.setOnClickListener(clickListener);

    }

    Intent intent;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.commit:
                    intent = new Intent(YiHomeActivity.this,OrderToPageActivity.class);
                    startActivity(intent); //跳转到订单生成页面
                    break;
                case R.id.arow_right:

                    break;
                case R.id.shop:
                    intent = new Intent(YiHomeActivity.this, MyShoppingcartchoose.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    //找到控件
    public void findView(){
        back = (ImageView) findViewById(R.id.back);
        name = (TextView) findViewById(R.id.name);
        commit = (Button) findViewById(R.id.commit);
        arowRight = (ImageView) findViewById(R.id.arow_right);
        shop = (ImageView) findViewById(R.id.shop);
    }
}
