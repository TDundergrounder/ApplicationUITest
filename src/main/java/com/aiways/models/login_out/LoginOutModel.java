package com.aiways.models.login_out;

import com.google.gson.Gson;

import java.io.Serializable;

public class LoginOutModel implements Serializable {

    private String mobile;

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

    private String code;

    public LoginOutModel(String mobile, String code) {
        this.mobile = mobile;
        this.code = code;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
