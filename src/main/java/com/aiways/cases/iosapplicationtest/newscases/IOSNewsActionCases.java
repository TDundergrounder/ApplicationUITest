package com.aiways.cases.iosapplicationtest.newscases;

import com.aiways.Invokers.iosInvokers.IOSSetCapabilitiesInvoker;
import com.aiways.cases.iosapplicationtest.AbstractIOSTestCase;
import com.aiways.dataprovider.iosDataProviders.IOSCommonDataProvider;
import com.aiways.dataprovider.iosDataProviders.IOSNewsDataProvider;
import com.aiways.models.iosModels.capability.IOSCapabilitiesModel;
import com.aiways.models.iosModels.common.IOSCommonModel;
import com.aiways.models.iosModels.news.IOSNewsLocateModel;
import com.aiways.models.iosModels.news.IOSNewsModel;
import com.google.gson.Gson;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IOSNewsActionCases extends AbstractIOSTestCase {

    IOSDriver<IOSElement> driver = null;

    Boolean is_login;

    int waitTime;

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

    //传入参数,赋值is_login
    @Test(dataProvider = IOSCommonDataProvider.DATA_GETCOMMONDATA, dataProviderClass = IOSCommonDataProvider.class,
            priority = 0)
    private void ifLogin(IOSCommonModel model) {
        this.is_login = _ioscommonInvoker.isLogin(model,driver);
        Assert.assertTrue(is_login, "已登录");
    }

    @Test(dataProvider = IOSNewsDataProvider.DATA_GETLOGINOUTDATA,dataProviderClass = IOSNewsDataProvider.class,priority = 1)
    private void NewsAction1(IOSNewsModel mode,IOSNewsLocateModel locateModel){
        _iosnewsInvoker.viewNewsDetail(driver,locateModel,2);
        _iosnewsInvoker.viewNewsDetailBanner(driver,locateModel);
    }


    @AfterTest
    private void quit(){
        driver.quit();
    }
}
