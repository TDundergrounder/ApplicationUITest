package com.aiways.models.androidModels.capability;

import com.google.gson.Gson;

import java.io.Serializable;

public class AndroidCapabilitiesModel implements Serializable {
    private String platformName;

    private String platformVersion;

    private String deviceName;

    public AndroidCapabilitiesModel(String platformName, String platformVersion, String deviceName, String appPackage, String appActivity, String noReset, String resetKeyboard) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.noReset = noReset;
        this.resetKeyboard = resetKeyboard;
    }

    private String appPackage;

    private String appActivity;

    private String noReset;

    private String resetKeyboard;


    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getNoReset() {
        return noReset;
    }

    public void setNoReset(String noReset) {
        this.noReset = noReset;
    }

    public String getResetKeyboard() {
        return resetKeyboard;
    }

    public void setResetKeyboard(String resetKeyboard) {
        this.resetKeyboard = resetKeyboard;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
