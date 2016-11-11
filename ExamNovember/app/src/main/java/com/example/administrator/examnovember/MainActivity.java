package com.example.administrator.examnovember;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {

                int i=0;
                while(i<100){
                    i++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message=new Message();
                    message.arg1=i;
                    handler.sendMessage(message);
                    if(i==99){
                        i=0;
                    }
                }
            }
        }).start();
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            progressBar.setProgress(msg.arg1);
            super.handleMessage(msg);
        }
    };
    public void createDB(){
        MySQLiteOpenHelper sqLiteOpenHelper=new MySQLiteOpenHelper(this,"diaryOpenHelper.db",null,1);
        SQLiteDatabase db=sqLiteOpenHelper.getWritableDatabase();
    }
}
