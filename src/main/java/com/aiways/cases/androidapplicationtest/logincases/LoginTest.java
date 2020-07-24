package com.aiways.cases.androidapplicationtest.logincases;


import com.aiways.utilities.SwipeTool;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class LoginTest {

    private static AndroidDriver<AndroidElement> driver;

    private static SwipeTool swipe = new SwipeTool();

    private static String mobile = "15800000070";

    private static String code = "223456";

    @BeforeTest
    public static void initApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "HUAWEI_Aiways");
        capabilities.setCapability("appPackage", "com.aiways.auto");
        capabilities.setCapability("appActivity", "com.aiways.auto.business.SplashActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("resetKeyboard", "true");
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //by对象是否存在
    public boolean byElementIsExist(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }


    @Test
    public void loginOrlogout() {
        try {
            //skip startpage
            driver.findElementById("com.aiways.auto:id/surface_container").click();

            Thread.sleep(2000);
            //click mine
            driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"我的\"]/android.widget.ImageView").click();
            Thread.sleep(2000);

            //login or not
            if (byElementIsExist(By.id("com.aiways.auto:id/tv_login"))) {
//                assert false : "当前未登录";
                System.out.println("当前未登录");
                try {
                    //click login/reg
                    driver.findElementById("com.aiways.auto:id/tv_login").click();
                    Thread.sleep(2000);
                    //login page --> input mobile
                    AndroidElement mobileInput = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText");
                    mobileInput.sendKeys(mobile);
                    Thread.sleep(2000);
                    //click getcode
                    //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.Button").click();
                    //input code
                    AndroidElement codeInput = driver.findElementByXPath("\t\n" +
                            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
                    codeInput.sendKeys(code);
                    //click login btn
                    AndroidElement loginBtn = driver.findElementById("com.aiways.auto:id/btn_login");
                    Thread.sleep(2000);
                    loginBtn.click();
                } catch (NullPointerException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                assert true : "用户已登录";
                try {
                    //swip up page
                    swipe.SwipeUp(driver);
                    Thread.sleep(1000);
                    //click setting
                    driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[11]/android.widget.RelativeLayout/android.widget.LinearLayout").click();
                    Thread.sleep(2000);
                    //click logout
                    driver.findElementByXPath("\t\n" +
                            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout").click();
                    Thread.sleep(2000);
                    //confirm quit
                    driver.findElementById("com.aiways.auto:id/common_custom_dialog_right_btn_tv").click();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void quitApp() {
        driver.quit();
    }
}
