package com.aiways.cases.iosapplicationtest.logincases;

import com.aiways.Invokers.iosInvokers.IOSSetCapabilitiesInvoker;
import com.aiways.cases.iosapplicationtest.AbstractIOSTestCase;
import com.aiways.dataprovider.iosDataProviders.IOSLoginOutDataProvider;
import com.aiways.models.iosModels.capability.IOSCapabilitiesModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutModel;
import com.google.gson.Gson;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginOutCases extends AbstractIOSTestCase {

    IOSDriver<IOSElement> driver = null;

    int waitTime = 3;

    @BeforeTest
    private void start(){
        String CapJsonStr = "{\n" +
                "  \"platformName\": \"iOS\",\n" +
                "  \"udid\": \"00008020-0008343C0E42002E\",\n" +
                "  \"platformVersion\": \"13.3.1\",\n" +
                "  \"deviceName\": \"Qa iPhoneMax\",\n" +
                "  \"automationName\": \"XCUITest\",\n" +
                "  \"bundleId\": \"com.aiways.auto\"\n" +
                "}";
        IOSCapabilitiesModel model = new Gson().fromJson(CapJsonStr, IOSCapabilitiesModel.class);
        driver = IOSSetCapabilitiesInvoker.getInstance().InitDriver(model, "http://127.0.0.1:4723/wd/hub");
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    @Test(dataProvider = IOSLoginOutDataProvider.DATA_GETLOGINOUTDATA,dataProviderClass = IOSLoginOutDataProvider.class)
    private void RunLoginOut(IOSLoginOutModel model, IOSLoginOutLocateModel loc_model){

        _iosloginoutInvoker.loginOut(model,loc_model,driver);

    }

    @AfterTest
    private void quit(){
        driver.quit();
    }

}

