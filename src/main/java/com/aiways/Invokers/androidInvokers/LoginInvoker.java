package com.aiways.Invokers.androidInvokers;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.androidModels.login_out.LoginOutLocateModel;
import com.aiways.models.androidModels.login_out.LoginOutModel;
import com.aiways.utilities.AssertMethodsClass;
import com.aiways.utilities.SwipeTools.SwipeTool;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//全局只有一个实例
@Scope(SpringConstants.SCOPE_SINGLETON)
public class LoginInvoker extends AbstractInvoker {

    public LoginInvoker() {
        super(TestConstants.GROUP_LOGINOUT);
    }


    public void loginOut(LoginOutModel model, LoginOutLocateModel loc_model, AndroidDriver<AndroidElement> driver) {
        try {
//            driver.findElementByAndroidUIAutomator()
            AssertMethodsClass assertMethodsClass = new AssertMethodsClass();
            Boolean homePageExist = assertMethodsClass.byElementIsExist(By.xpath(loc_model.getMine_xpath()),driver);
            if(!homePageExist) {
                SwipeTool swipeTool = new SwipeTool();
                for (int i = 0; i < 5; i++) {
                    swipeTool.SwipeLeft(driver);
                    Thread.sleep(2000);
                };
                driver.findElementById("com.aiways.auto:id/btn_guide_start").click();
            }
            Thread.sleep(3000);
            if(assertMethodsClass.byElementIsExist(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"),driver)){
                driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
            }
            Thread.sleep(5000);
            //click mine
            AndroidElement elementMine = driver.findElementByXPath(loc_model.getMine_xpath());
            elementMine.click();
            Thread.sleep(1000);
            Boolean islogin = new AssertMethodsClass().byElementIsExist(By.id(loc_model.getIsLoginTag_id()), driver);
            //login or not
            if (!islogin) {
                System.out.println("当前未登录");
                try {
                    //click login/reg
                    driver.findElementById("com.aiways.auto:id/tv_login").click();
                    Thread.sleep(2000);
                    //login page --> input mobile
                    AndroidElement mobileInput = driver.findElementByXPath(loc_model.getMobile_xpath());
                    mobileInput.sendKeys(model.getMobile());
                    Thread.sleep(2000);
                    //click getcode
                    //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.Button").click();
                    //input code
                    AndroidElement codeInput = driver.findElementByXPath(loc_model.getCode_xpath());
                    codeInput.sendKeys(model.getCode());
                    //click login btn
                    AndroidElement loginBtn = driver.findElementById(loc_model.getLoginBtn_id());
                    Thread.sleep(2000);
                    loginBtn.click();
                    if (islogin) {
                        System.out.println("已登录成功");
                    }
                } catch (NullPointerException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                System.out.println("用户已登录");
                try {
                    SwipeTool swipe = new SwipeTool();
                    //swip up page
                    swipe.SwipeUp(driver);
                    Thread.sleep(2000);
                    List<AndroidElement> elementList_Mine = driver.findElementsByClassName(loc_model.getMineRelativeLayoutClass_name());
                    elementList_Mine.get(20).click();
//                    System.out.println(elementList.size());
                    //click setting
                    //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[11]/android.widget.RelativeLayout/android.widget.LinearLayout").click();
                    //click logout
                    List<AndroidElement> elementList_Settings = driver.findElementsByClassName(loc_model.getSettingRelativeLayoutClass_name());
                    elementList_Settings.get(14).click();
                    //confirm quit
                    driver.findElementById(loc_model.getConfirmQuit_btn()).click();
                    Thread.sleep(1000);
                    swipe.SwipeDown(driver);
                    Thread.sleep(5000);
                    if (!islogin) {
                        System.out.println("已退出登录");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

