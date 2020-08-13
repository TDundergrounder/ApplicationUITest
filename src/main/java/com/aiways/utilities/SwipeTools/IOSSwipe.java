package com.aiways.utilities.SwipeTools;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class IOSSwipe {
    //上滑到屏幕底部
    public void SwipeUpToBottom(IOSDriver driver, String endString) throws InterruptedException {
        boolean isSwipe = true;
    // 滑动屏幕直到页面底部
        while (isSwipe) {
            SwipeUp(driver);//向上滑动屏幕
            String temp =driver.getPageSource();
            if(temp.contains(endString) ) {
                Thread.sleep(3000);
                isSwipe = false;
            }
        }
    }

    //下滑到屏幕顶部
    public void SwipeDownToTop(IOSDriver driver, String endString) throws InterruptedException {
        boolean isSwipe = true;
        // 滑动屏幕直到页面底部
        while (isSwipe) {
            SwipeDown(driver);//向上滑动屏幕
            String temp =driver.getPageSource();
            if(temp.contains(endString) ) {
                Thread.sleep(3000);
                isSwipe = false;
            }
        }
    }


    // 上滑
    public void SwipeUp(IOSDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width/2, height))
                .moveTo(PointOption.point(width/2, 10))
                .release()
                .perform();
    }

    // 下滑
    public void SwipeDown(IOSDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(195,120))
                .moveTo(PointOption.point(195, 800))
                .release()
                .perform();
    }
}
