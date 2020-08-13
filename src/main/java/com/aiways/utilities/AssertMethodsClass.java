package com.aiways.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class AssertMethodsClass {

    //by对象是否存在
    public boolean byElementIsExist(By by, AndroidDriver<AndroidElement> driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean byIOSElementIsExist(By by, IOSDriver<IOSElement> driver){
        try {
            driver.findElement(by);
            return true;
        }catch (Exception e){
            // TODO: handle exception
            return false;
        }
    }

    public boolean byIOSpredicateExist(IOSDriver<IOSElement> driver,String predicateStr) {

        try {
            driver.findElementByIosNsPredicate(predicateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
