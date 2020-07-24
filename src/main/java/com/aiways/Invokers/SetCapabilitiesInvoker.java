package com.aiways.Invokers;

import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.capability.AndroidCapabilitiesModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SetCapabilitiesInvoker extends AbstractInvoker {

    /* 对SetCapabilitiesInvoker做单例处理 */

    public static AndroidDriver<AndroidElement> driver = null;

    private SetCapabilitiesInvoker() {
        super(TestConstants.GROUP_CAPABILITIES);
    }

    private static SetCapabilitiesInvoker capabilitiesInvoker = new SetCapabilitiesInvoker();

    public static SetCapabilitiesInvoker getInstance(){
        return capabilitiesInvoker;
    }

    public static final List<AndroidDriver<AndroidElement>> driverList = new ArrayList<AndroidDriver<AndroidElement>>();
    /* 初始化一个AndroidDriver */

    public AndroidDriver<AndroidElement> InitDriver(AndroidCapabilitiesModel model, String remoteUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        /* fastjson解析方法 */
        JSONObject capJson = JSON.parseObject(model.toString());

        //遍历取值
        for (Map.Entry<String, Object> entry : capJson.entrySet()) {

            System.out.println(entry.getKey() + ":" + entry.getValue() + "," + "\n");

            capabilities.setCapability(entry.getKey(), entry.getValue());
        }

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(remoteUrl), capabilities);
            driverList.add(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}


