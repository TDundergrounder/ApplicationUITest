package com.aiways.Invokers.iosInvokers;

import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.iosModels.common.IOSCommonModel;
import com.aiways.utilities.AssertMethodsClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class IOSCommonInvoker extends AbstractInvoker {

    public IOSCommonInvoker() {
        super(TestConstants.GROUP_COMMON);
    }

    public String userName;


    //判断是否已登录
    public boolean isLogin(IOSCommonModel model, IOSDriver<IOSElement> driver) {
        IOSElement elementMine = driver.findElementByXPath(model.getMine_xpath());
        elementMine.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean islogin =
                new AssertMethodsClass().byIOSElementIsExist(By.name(model.getIsLogin_name()), driver);
        System.out.println("commonInvoker判断islogin的值：");
        System.out.println(islogin);
        //判断登录成功后，获取用户昵称
        if (islogin) {
            List<IOSElement> iosElements = driver.findElementsByIosNsPredicate("type == 'XCUIElementTypeButton'");
            int index = iosElements.indexOf(driver.findElementByIosNsPredicate("type == 'XCUIElementTypeButton' AND label == '编辑签名'")) - 1;
            this.userName = iosElements.get(index).getText();
            System.out.println("用户昵称:" + this.userName);
        }
        return islogin;
    }
}

