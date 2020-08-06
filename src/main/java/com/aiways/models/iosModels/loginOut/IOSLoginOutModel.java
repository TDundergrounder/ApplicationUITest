package com.aiways.models.iosModels.loginOut;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSLoginOutModel implements Serializable {

    private String mobile;

    private String code;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IOSLoginOutModel(String mobile, String code) {
        this.mobile = mobile;
        this.code = code;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
