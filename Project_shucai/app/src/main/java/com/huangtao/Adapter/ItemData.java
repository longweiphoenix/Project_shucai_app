package com.huangtao.Adapter;

/**
 * Created by Administrator on 2016/12/1.
 */
public class ItemData {
    private int image;  //头像
    private String name; //名字
    private int dynamicState; //动态
    private int fans; //粉丝

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getDynamicState() {
        return dynamicState;
    }

    public void setDynamicState(int dynamicState) {
        this.dynamicState = dynamicState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
