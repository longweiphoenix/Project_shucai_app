package com.example.zxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.along.ui1project.R;
import com.example.first.project.MyFoodActivity;

/**
 * Created by Administrator on 2016/10/23.
 */
public class InviteFriend extends Activity {
    ImageView inviteArowImageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);
        inviteArowImageView = (ImageView) findViewById(R.id.invite_arow_imageView);
        inviteArowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InviteFriend.this, MyFoodActivity.class);
                startActivity(intent);
            }
        });
    }
}
