package com.aiways.cases.iosapplicationtest.newscases;

import com.aiways.cases.iosapplicationtest.AbstractIOSTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.dataprovider.iosDataProviders.IOSCommonDataProvider;
import com.aiways.models.iosModels.common.IOSCommonModel;
import com.aiways.utilities.DataGenera;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSNewsActionCases extends AbstractIOSTestCase {

    IOSDriver<IOSElement> driver = null;

    Boolean is_login;

    int waitTime;

    int index = 3;

    @BeforeTest
    private void start() {
        try {
            driver = new IOSDriver<IOSElement>(
                    new URL(TestConfiguration.instance().get_appium_remoteServer()),
                    new DataGenera().getIosCapabilities(TestConfiguration.instance().get_capabilitiesMap())
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    //传入参数,赋值is_login
    @Test(dataProvider = IOSCommonDataProvider.DATA_GETCOMMONDATA, dataProviderClass = IOSCommonDataProvider.class,
            priority = 1)
    private void ifLogin(IOSCommonModel model) {
        this.is_login = _ioscommonInvoker.isLogin(model, driver);
        Assert.assertTrue(is_login, "已登录");
    }


    //执行用例,查看详情页banner
//    @Test(dataProvider = IOSNewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = IOSNewsDataProvider.class,
//            priority = 2)
//    private void NewsAction1(IOSNewsModel model, IOSNewsLocateModel locateModel) {
//        _iosnewsInvoker.viewNewsDetail(driver, locateModel, index);
//        _iosnewsInvoker.viewNewsDetailBanner(driver, locateModel);
//    }


    //添加评论
//    @Test(dataProvider = IOSNewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = IOSNewsDataProvider.class,
//            priority = 3)
//    private void NewsAction2(IOSNewsModel model, IOSNewsLocateModel locateModel) {
//        _iosnewsInvoker.viewNewsDetail(driver, locateModel, index);
//        _iosnewsInvoker.addComment(model, locateModel, driver);
//    }

    //添加回复
//    @Test(dataProvider = IOSNewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = IOSNewsDataProvider.class,
//            priority = 3)
//    private void NewsAction3(IOSNewsModel model, IOSNewsLocateModel locateModel) {
//        _iosnewsInvoker.viewNewsDetail(driver, locateModel, index);
//        _iosnewsInvoker.addReply(model, locateModel, driver);
//    }


    @AfterTest
    private void quit() {
        driver.quit();
    }
}
