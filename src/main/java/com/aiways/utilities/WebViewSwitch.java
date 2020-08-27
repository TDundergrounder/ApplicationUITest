package com.aiways.utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gyliang
 */

public class WebViewSwitch {

    public int MAX_TIMEOUT_SECONDS = 30;

    //切换到最后的一个webview
    public void switchToLastWebView(AndroidDriver<MobileElement> driver) {
        Set<String> contextNames = driver.getContextHandles();
        for(String item :contextNames){
            // NATIVE_APP
            //WEBVIEW_com.xxx.xxxx
            System.out.println(item);
        }
        List<String> webViewContextNames = contextNames
                .stream()
                .filter(contextName -> contextName.contains("WEBVIEW_"))
                .collect(Collectors.toList());
        String currentContextView = "";

        if (webViewContextNames.size() > 0) {
            currentContextView = (String) webViewContextNames.toArray()[webViewContextNames.size() - 1];
            driver.context(currentContextView);
        }
//        LOGGER.log(Level.INFO, "All contexts:" + contextNames);
//        LOGGER.log(Level.INFO, "All webview contexts:" + webViewContextNames);
//        LOGGER.log(Level.INFO, "current context:" + driver.getContext());
    }


    //在超时时段内，精确切换到需要找到的webview
    public String switchToSpecificWebView(By selector,AndroidDriver<MobileElement> driver) {
        switchToLastWebView(driver);
        long begin = System.currentTimeMillis();
        do {
            try {
                //轮训出当前context中包含的Element，即可跳出轮训，否则继续执行直至timeout
                List<MobileElement> elements = driver.findElements(selector);
                if (null != elements && elements.size() > 0) {
                    return "Successed! Element exist! ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            switchToLastWebView(driver);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while ((System.currentTimeMillis() - begin) < MAX_TIMEOUT_SECONDS * 1000);
        return "Failed due to TimeOut!";
    }
}
