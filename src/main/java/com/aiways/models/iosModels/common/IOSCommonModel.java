package com.aiways.models.iosModels.common;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSCommonModel implements Serializable {

    private String mine_xpath;

    private String isLogin_name;

    public String getMine_xpath() {
        return mine_xpath;
    }

    public void setMine_xpath(String mine_xpath) {
        this.mine_xpath = mine_xpath;
    }

    public String getIsLogin_name() {
        return isLogin_name;
    }

    public void setIsLogin_name(String isLogin_name) {
        this.isLogin_name = isLogin_name;
    }

    public IOSCommonModel(String mine_xpath, String isLogin_name) {
        this.mine_xpath = mine_xpath;
        this.isLogin_name = isLogin_name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
