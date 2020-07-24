package com.aiways.models.login_out;

import com.google.gson.Gson;

import java.io.Serializable;

public class LoginOutLocateModel implements Serializable {

    private String isLoginTag_id;
    private String mobile_xpath;
    private String code_xpath;
    private String loginBtn_id;
    private String MineRelativeLayoutClass_name;
    private String SettingRelativeLayoutClass_name;
    private String confirmQuit_btn;
    private String mine_xpath;


    public String getIsLoginTag_id() {
        return isLoginTag_id;
    }

    public void setIsLoginTag_id(String isLoginTag_id) {
        this.isLoginTag_id = isLoginTag_id;
    }

    public String getMobile_xpath() {
        return mobile_xpath;
    }

    public void setMobile_xpath(String mobile_xpath) {
        this.mobile_xpath = mobile_xpath;
    }

    public String getCode_xpath() {
        return code_xpath;
    }

    public void setCode_xpath(String code_xpath) {
        this.code_xpath = code_xpath;
    }

    public String getLoginBtn_id() {
        return loginBtn_id;
    }

    public void setLoginBtn_id(String loginBtn_id) {
        this.loginBtn_id = loginBtn_id;
    }

    public String getMineRelativeLayoutClass_name() {
        return MineRelativeLayoutClass_name;
    }

    public void setMineRelativeLayoutClass_name(String mineRelativeLayoutClass_name) {
        MineRelativeLayoutClass_name = mineRelativeLayoutClass_name;
    }

    public String getSettingRelativeLayoutClass_name() {
        return SettingRelativeLayoutClass_name;
    }

    public void setSettingRelativeLayoutClass_name(String settingRelativeLayoutClass_name) {
        SettingRelativeLayoutClass_name = settingRelativeLayoutClass_name;
    }

    public String getConfirmQuit_btn() {
        return confirmQuit_btn;
    }

    public void setConfirmQuit_btn(String confirmQuit_btn) {
        this.confirmQuit_btn = confirmQuit_btn;
    }

    public String getMine_xpath() {
        return mine_xpath;
    }

    public void setMine_xpath(String mine_xpath) {
        this.mine_xpath = mine_xpath;
    }

    public LoginOutLocateModel(String isLoginTag_id, String mobile_xpath, String code_xpath, String loginBtn_id, String MineRelativeLayoutClass_name, String SettingRelativeLayoutClass_name, String confirmQuit_btn, String mine_xpath) {
        this.isLoginTag_id = isLoginTag_id;
        this.mobile_xpath = mobile_xpath;
        this.code_xpath = code_xpath;
        this.loginBtn_id = loginBtn_id;
        this.MineRelativeLayoutClass_name = MineRelativeLayoutClass_name;
        this.SettingRelativeLayoutClass_name = SettingRelativeLayoutClass_name;
        this.confirmQuit_btn = confirmQuit_btn;
        this.mine_xpath = mine_xpath;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
