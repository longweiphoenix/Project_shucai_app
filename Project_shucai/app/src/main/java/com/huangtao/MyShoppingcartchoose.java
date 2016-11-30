package com.huangtao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.ui1project.R;
import com.huangtao.Adapter.MyShoppingCartChooseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class MyShoppingcartchoose extends Activity {
    ListView listView;
    List<HashMap<String,Object>> list;
    LayoutInflater layoutInflater;
    ImageView shoppingcartReturnArow;//购物车返回按钮
    TextView shoppingcartEdit;//编辑按钮;
    LinearLayout shoppingcartBottom;//购物车底部结算栏
    private  static boolean  EDIT=false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodegwucbji);
        listView= (ListView) findViewById(R.id.shoppingcart_listview);
        shoppingcartEdit= (TextView)findViewById(R.id.shoppingcart_edit);
        shoppingcartReturnArow= (ImageView) findViewById(R.id.shoppingcart_return_arow);
        shoppingcartBottom= (LinearLayout) findViewById(R.id.shoppingcart_bottom);

        list=new ArrayList<>();
        getDate();
        listView.setAdapter(new MyShoppingCartChooseAdapter(this,list));
        layoutInflater=LayoutInflater.from(this);

        shoppingcartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义EDIT初始false
                if(EDIT){
                    EDIT=false;
                    shoppingcartEdit.setText("编辑");
                    shoppingcartBottom.setVisibility(View.VISIBLE);
                }else{
                    EDIT=true;
                    shoppingcartEdit.setText("完成");
                    shoppingcartBottom.setVisibility(View.GONE);
                }
                //重新适配
                list=new ArrayList<>();
                getDate();
                listView.setAdapter(new MyShoppingCartChooseAdapter(MyShoppingcartchoose.this,list));
                listView.setItemsCanFocus(true);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //添加按钮   //减少按钮   //删除按钮
            ImageView productAdd,productSub,shoppingcartDelete;
            //购买的数量
            TextView productNumber;


            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                productNumber= (TextView) view.findViewById(R.id.product_number);
                shoppingcartDelete= (ImageView) view.findViewById(R.id.shoppingcart_delete);
                productAdd= (ImageView) view.findViewById(R.id.product_add);
                productSub= (ImageView) view.findViewById(R.id.product_sub);
                shoppingcartDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.remove(position);
                        listView.setAdapter(new MyShoppingCartChooseAdapter(MyShoppingcartchoose.this,list));
                    }
                });
                productAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       productNumber.setText(""+(Integer.parseInt(productNumber.getText().toString())+1));
                    }
                });
            }
        });

       //购物车返回箭头
        shoppingcartReturnArow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShoppingcartchoose.this,"123123",Toast.LENGTH_LONG).show();
            }
        });



    }

    public void getDate(){
        Integer[] image=new Integer[]{R.mipmap.dojiatu,R.mipmap.huactu,R.mipmap.copop,R.mipmap.copop,R.mipmap.copop,R.mipmap.copop};
        String[] name =getResources().getStringArray(R.array.product_name);
        String[] introduce=getResources().getStringArray(R.array.product_introduce);
        String[] price=getResources().getStringArray(R.array.product_price);
        for (int i=0;i<image.length;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("productImage",image[i]);
            map.put("productName",name[i]);
            map.put("productIntroduce",introduce[i]);
            map.put("productPrice",price[i]);
            map.put("booleanDelete",EDIT);
            list.add(map);
        }
    }
}
