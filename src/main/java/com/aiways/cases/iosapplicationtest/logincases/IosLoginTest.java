package com.aiways.cases.iosapplicationtest.logincases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IosLoginTest {

    public  static IOSDriver<IOSElement> driver = null;

    @BeforeTest
    public static void initApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "13.3.1");
        capabilities.setCapability("deviceName", "Qa iPhoneMax");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("bundleId", "com.aiways.auto");
        capabilities.setCapability("udid", "00008020-0008343C0E42002E");
        try {
            driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
