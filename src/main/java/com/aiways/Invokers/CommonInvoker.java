package com.aiways.Invokers;

import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.Common.CommonModel;
import com.aiways.utilities.AssertMethodsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class CommonInvoker extends AbstractInvoker {

    public CommonInvoker(){
        super(TestConstants.GROUP_COMMON);
    }

    public String userName;

    //判断是否已登录
    public boolean isLogin(CommonModel model,AndroidDriver<AndroidElement> driver) {
        AndroidElement elementMine = driver.findElementByXPath(model.getMine_xpath());
        elementMine.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean islogin =
                new AssertMethodsClass().byElementIsExist(By.id(model.getIsLoginTag_id()), driver);
        System.out.println("commonInvoker判断islogin的值：");
        System.out.println(islogin);
        if(islogin){
            this.userName = driver.findElementById("com.aiways.auto:id/tv_name").getText();
        }
        return islogin;
    }
}
