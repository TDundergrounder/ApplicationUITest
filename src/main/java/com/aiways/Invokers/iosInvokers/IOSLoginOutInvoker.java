package com.aiways.Invokers.iosInvokers;


import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutModel;
import com.aiways.utilities.AssertMethodsClass;
import com.aiways.utilities.SwipeTools.IOSSwipe;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class IOSLoginOutInvoker extends AbstractInvoker {

    public IOSLoginOutInvoker(){
        super(TestConstants.GROUP_LOGINOUT);
    }

    public void loginOut(IOSLoginOutModel model, IOSLoginOutLocateModel loc_model, IOSDriver<IOSElement> driver) {
        try {
            Thread.sleep(5000);
            //click mine
            IOSElement elementMine = driver.findElementByXPath(loc_model.getMine_xpath());
            elementMine.click();
            Thread.sleep(1000);
            Boolean islogin = new AssertMethodsClass().byIOSElementIsExist(By.name(loc_model.getIsLogin_name()), driver);
            //login or not
            if (!islogin) {
                System.out.println("当前未登录");
                try {
                    //click login/reg
                    driver.findElementByIosNsPredicate(loc_model.getReglogin_IosNsPredicate()).click();
                    Thread.sleep(2000);
                    //login page --> input mobile
                    List<IOSElement> inputElements = driver.findElementsByIosNsPredicate(loc_model.getInput_IosNsPredicate());
                    inputElements.get(0).sendKeys(model.getMobile());
                    Thread.sleep(2000);
                    //click getcode
                    //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.aiways.sliding.SlidingLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.Button").click();
                    //input code
                    inputElements.get(1).sendKeys(model.getCode());
                    //click login btn
                    IOSElement loginBtn = driver.findElementByIosNsPredicate(loc_model.getLoginBtn_IosNsPredicate());
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
                    IOSSwipe swipe = new IOSSwipe();
                    //swip up page
                    swipe.SwipeUp(driver);
                    Thread.sleep(2000);
                    List<IOSElement> elementList_Mine = driver.findElementsByIosNsPredicate(loc_model.getSettingsBtn_IosNsPredicate());
                    System.out.println("mine size："+elementList_Mine.size());
                    IOSElement settingElement = elementList_Mine.get(elementList_Mine.size()-1);
                    //click setting
                    settingElement.click();
                    List<IOSElement> XCUIElementTypeButtonList = driver.findElementsByIosNsPredicate(loc_model.getLogoutBtn_IosNsPredicate());
                    System.out.println("settings size："+XCUIElementTypeButtonList.size());
                    IOSElement logoutElement = XCUIElementTypeButtonList.get(XCUIElementTypeButtonList.size()-1);
                    //click logout
                    logoutElement.click();
                    //confirm quit
                    driver.findElementByIosNsPredicate(loc_model.getConfirmlogoutBtn_IosNsPredicate()).click();
                    Thread.sleep(1000);
                    driver.findElementByAccessibilityId("navigation back").click();
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
