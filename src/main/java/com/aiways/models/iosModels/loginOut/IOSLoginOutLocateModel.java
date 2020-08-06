package com.aiways.models.iosModels.loginOut;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSLoginOutLocateModel implements Serializable {

    private String mine_xpath;

    private String isLogin_name;

    private String reglogin_IosNsPredicate;

    private String input_IosNsPredicate;

    private String loginBtn_IosNsPredicate;

    private String settingsBtn_IosNsPredicate;

    private String logoutBtn_IosNsPredicate;

    private String confirmlogoutBtn_IosNsPredicate;

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

    public String getReglogin_IosNsPredicate() {
        return reglogin_IosNsPredicate;
    }

    public void setReglogin_IosNsPredicate(String reglogin_IosNsPredicate) {
        this.reglogin_IosNsPredicate = reglogin_IosNsPredicate;
    }

    public String getInput_IosNsPredicate() {
        return input_IosNsPredicate;
    }

    public void setInput_IosNsPredicate(String input_IosNsPredicate) {
        this.input_IosNsPredicate = input_IosNsPredicate;
    }

    public String getLoginBtn_IosNsPredicate() {
        return loginBtn_IosNsPredicate;
    }

    public void setLoginBtn_IosNsPredicate(String loginBtn_IosNsPredicate) {
        this.loginBtn_IosNsPredicate = loginBtn_IosNsPredicate;
    }

    public String getSettingsBtn_IosNsPredicate() {
        return settingsBtn_IosNsPredicate;
    }

    public void setSettingsBtn_IosNsPredicate(String settingsBtn_IosNsPredicate) {
        this.settingsBtn_IosNsPredicate = settingsBtn_IosNsPredicate;
    }

    public String getLogoutBtn_IosNsPredicate() {
        return logoutBtn_IosNsPredicate;
    }

    public void setLogoutBtn_IosNsPredicate(String logoutBtn_IosNsPredicate) {
        this.logoutBtn_IosNsPredicate = logoutBtn_IosNsPredicate;
    }

    public String getConfirmlogoutBtn_IosNsPredicate() {
        return confirmlogoutBtn_IosNsPredicate;
    }

    public void setConfirmlogoutBtn_IosNsPredicate(String confirmlogoutBtn_IosNsPredicate) {
        this.confirmlogoutBtn_IosNsPredicate = confirmlogoutBtn_IosNsPredicate;
    }

    public IOSLoginOutLocateModel(String mine_xpath, String isLogin_name, String reglogin_IosNsPredicate, String input_IosNsPredicate, String loginBtn_IosNsPredicate, String settingsBtn_IosNsPredicate, String logoutBtn_IosNsPredicate, String confirmlogoutBtn_IosNsPredicate) {
        this.mine_xpath = mine_xpath;
        this.isLogin_name = isLogin_name;
        this.reglogin_IosNsPredicate = reglogin_IosNsPredicate;
        this.input_IosNsPredicate = input_IosNsPredicate;
        this.loginBtn_IosNsPredicate = loginBtn_IosNsPredicate;
        this.settingsBtn_IosNsPredicate = settingsBtn_IosNsPredicate;
        this.logoutBtn_IosNsPredicate = logoutBtn_IosNsPredicate;
        this.confirmlogoutBtn_IosNsPredicate = confirmlogoutBtn_IosNsPredicate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
