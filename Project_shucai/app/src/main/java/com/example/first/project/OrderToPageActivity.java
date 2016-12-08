package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.BaseActivity;
import com.example.along.ui1project.R;
import com.example.first.project.utils.TimerUtil;

/**订单生成界面
 * Created by Administrator on 2016/11/0008.
 */

public class OrderToPageActivity extends BaseActivity {
    ImageView back; //返回上一级页面
    TextView cancel; //取消订单
    TextView name; //收货人
    Button pay; //立即支付
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_to_page);
        findView();
        View view = LayoutInflater.from(OrderToPageActivity.this).inflate(R.layout.order_to_page,null);
//        Button button = (Button) view.findViewById(R.id.time);
//        new TimerUtil(button,1000*60*30,1000*60).start(); //倒计时
//        back.setOnClickListener(clickListener);
        cancel.setOnClickListener(clickListener);

    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back:
                    finish();
                    break;
                case R.id.cancel: //取消订单
                    Intent intent = new Intent(OrderToPageActivity.this,YiHomeActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    //找到控件
    public void findView(){
        back = (ImageView) findViewById(R.id.back);
        cancel = (TextView) findViewById(R.id.cancel);
        name = (TextView) findViewById(R.id.name);
        pay = (Button) findViewById(R.id.pay_now);
    }

}
