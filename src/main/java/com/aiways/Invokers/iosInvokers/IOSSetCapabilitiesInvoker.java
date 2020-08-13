package com.aiways.Invokers.iosInvokers;

import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.models.iosModels.capability.IOSCapabilitiesModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOSSetCapabilitiesInvoker extends AbstractInvoker {

    /* 对SetCapabilitiesInvoker做单例处理 */

    public static IOSDriver<IOSElement> driver = null;

    public static Map<String, Object> capEntry = null;

    private IOSSetCapabilitiesInvoker() {
        super(TestConstants.GROUP_CAPABILITIES);
    }

    private static IOSSetCapabilitiesInvoker iosSetCapabilitiesInvoker = new IOSSetCapabilitiesInvoker();

    public static IOSSetCapabilitiesInvoker getInstance(){
        return iosSetCapabilitiesInvoker;
    }

    public static final List<IOSDriver<IOSElement>> driverList = new ArrayList<IOSDriver<IOSElement>>();
    /* 初始化一个AndroidDriver */

    public IOSDriver<IOSElement> InitDriver(IOSCapabilitiesModel model, String remoteUrl) {
        DesiredCapabilities iosCapabilities = new DesiredCapabilities();

        /* fastjson解析方法 */
        JSONObject capJson = JSON.parseObject(model.toString());

        //遍历取值
        for (Map.Entry<String, Object> entry : capJson.entrySet()) {

            capEntry.put(entry.getKey(),entry.getValue());

            System.out.println(entry.getKey() + ":" + entry.getValue() + "," + "\n");

            iosCapabilities.setCapability(entry.getKey(), entry.getValue());
        }

        try {
            driver = new IOSDriver<IOSElement>(new URL(remoteUrl), iosCapabilities);
            driverList.add(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    

}


