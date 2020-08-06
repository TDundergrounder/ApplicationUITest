package com.aiways.models.iosModels.capability;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSCapabilitiesModel implements Serializable {

    private String platformName;

    private String udid;

    private String platformVersion;

    private String deviceName;

    private String automationName;

    private String bundleId;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
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

    public String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public IOSCapabilitiesModel(String platformName, String udid, String platformVersion, String deviceName, String automationName, String bundleId) {
        this.platformName = platformName;
        this.udid = udid;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.automationName = automationName;
        this.bundleId = bundleId;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
