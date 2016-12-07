package com.example.first.project.application;

import android.app.Application;

/**
 * Created by Administrator on 2016/12/0006.
 */

public class DataApplication extends Application {
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
