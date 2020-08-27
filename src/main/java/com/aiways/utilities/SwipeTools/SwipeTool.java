package com.aiways.utilities.SwipeTools;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.util.List;


public class SwipeTool {

    //上滑到屏幕底部
    public void SwipeUpToBottom(AndroidDriver driver,String endString) throws InterruptedException {
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

    // 上滑
    public void SwipeUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width/2, height-200))
                .moveTo(PointOption.point(width/2, 300))
                .release()
                .perform();
    }

    // 下滑
    public void SwipeDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width/2,height/3))
                .moveTo(PointOption.point(width / 2, height-300))
                .release()
                .perform();
    }

    // 左滑
    public void SwipeLeft(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(width - 900, height / 2))
                .release()
                .perform();
    }

    public void SwipeLeftTo(AndroidDriver driver,String endString) throws InterruptedException {
        boolean isSwipe = true;
// 滑动屏幕直到页面底部
        while (isSwipe) {
            SwipeLeft(driver);//向左滑动屏幕
            String temp =driver.getPageSource();
            if(temp.contains(endString) ) {
                Thread.sleep(3000);
                isSwipe = false;
            }
        }
    }

    // 右滑
    public void SwipeRight(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }
}


