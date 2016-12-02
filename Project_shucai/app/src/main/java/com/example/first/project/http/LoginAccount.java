package com.example.first.project.http;

import java.net.URL;

/**
 * Created by Administrator on 2016/12/0002.
 */

public class LoginAccount {
    String STR_URL = "http://10.0.2.2/index.php/home/index/login?";
    String username;
    String phonenumb;
    String passWord;

    URL url;
    public LoginAccount(String info,String passWord){
        this.passWord = passWord;
        //if ()
        //url = new URL(STR_URL+);
    }
}
