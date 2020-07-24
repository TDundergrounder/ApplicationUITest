package com.aiways.models.Common;

import com.google.gson.Gson;

public class CommonModel {

    private String isLoginTag_id;

    private String mine_xpath;

    public String getMine_xpath() {
        return mine_xpath;
    }

    public void setMine_xpath(String mine_xpath) {
        this.mine_xpath = mine_xpath;
    }

    public String getIsLoginTag_id() {
        return isLoginTag_id;
    }

    public void setIsLoginTag_id(String isLoginTag_id) {
        this.isLoginTag_id = isLoginTag_id;
    }

    public CommonModel(String isLoginTag_id,String mine_xpath) {

        this.isLoginTag_id = isLoginTag_id;
        this.mine_xpath = mine_xpath;

    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
