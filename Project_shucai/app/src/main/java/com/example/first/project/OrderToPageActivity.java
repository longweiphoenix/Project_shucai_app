package com.example.first.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.along.ui1project.R;

/**订单生成界面
 * Created by Administrator on 2016/11/0008.
 */

public class OrderToPageActivity extends Activity {
    ImageView back; //返回上一级页面
    TextView cancel; //取消订单
    TextView name; //收货人
    Button pay; //立即支付
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_to_page);
        findView();
        back.setOnClickListener(clickListener);

    }

    Intent intent;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back:
                    intent = new Intent(OrderToPageActivity.this,YiHomeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.cancel:
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
