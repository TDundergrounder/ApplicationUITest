package com.aiways.constants;

import com.google.gson.Gson;

import java.util.*;

public class TestCapilitiesConstants {

    private String CapJsonStr_iPhoneXSMax = "{\n" +
            "  \"platformName\": \"iOS\",\n" +
            "  \"udid\": \"00008020-0008343C0E42002E\",\n" +
            "  \"platformVersion\": \"13.3.1\",\n" +
            "  \"deviceName\": \"Qa iPhoneMax\",\n" +
            "  \"automationName\": \"XCUITest\",\n" +
            "  \"bundleId\": \"com.aiways.auto\"\n" +
            "}";


    private String CapJsonStr_HUAWEI = "{\n" +
            "  \"noReset\": true,\n" +
            "  \"resetKeyboard\": true,\n" +
            "  \"appActivity\": \"com.aiways.auto.business.SplashActivity\",\n" +
            "  \"appPackage\": \"com.aiways.auto\",\n" +
            "  \"deviceName\": \"HUAWEI_Aiways\",\n" +
            "  \"platformVersion\": \"10.0\",\n" +
            "  \"platformName\": \"Android\"\n" +
            "}";


    public Map<String, List<HashMap<String,String>>> capabilitiesMap = new HashMap<String, List<HashMap<String,String>>>();

    public void setCapabilitiesMap(){

        List<HashMap<String,String>> androidCapabilitiesList = new ArrayList<>();
        List<HashMap<String,String>> iosCapabilitiesList = new ArrayList<>();

        capabilitiesMap.put("android",androidCapabilitiesList);
        capabilitiesMap.put("ios",iosCapabilitiesList);

        Map<String,String> androidCapMap = new HashMap<String,String>();
        androidCapMap = new Gson().fromJson(CapJsonStr_HUAWEI,androidCapMap.getClass());

        Map<String,String> iosCapMap = new HashMap<String,String>();
        iosCapMap = new Gson().fromJson(CapJsonStr_iPhoneXSMax,iosCapMap.getClass());

        iosCapabilitiesList.add((HashMap<String, String>) iosCapMap);
        androidCapabilitiesList.add((HashMap<String, String>) androidCapMap);
    }

    public static void main(String[] args) {
        TestCapilitiesConstants capilitiesConstants = new TestCapilitiesConstants();
        capilitiesConstants.setCapabilitiesMap();
        Map<String, List<HashMap<String, String>>> map = capilitiesConstants.capabilitiesMap;
        for (String key : map.keySet()) {
            for (HashMap<String, String> capMap : map.get(key)) {
                System.out.println(key + ":" + capMap);
            }
        }
    }
}
