package com.aiways.cases.iosapplicationtest.capabilitiescases;

import com.aiways.Invokers.iosInvokers.IOSSetCapabilitiesInvoker;
import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.iosDataProviders.IOSCapabilitiesDataProvider;
import com.aiways.models.iosModels.capability.IOSCapabilitiesModel;
import com.aiways.utilities.ClientGroup;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test(groups = TestConstants.GROUP_CAPABILITIES,singleThreaded = true )
@ClientGroup(TestConstants.GROUP_CAPABILITIES)
public class GetIOSCapCases extends AbstractTestCase {

    IOSDriver<IOSElement> driver = null;

    @BeforeTest
    private void startTest(){
        System.out.println("start running!");

    }


    @Test(dataProvider = IOSCapabilitiesDataProvider.DATA_GETCAPABILITIES,dataProviderClass = IOSCapabilitiesDataProvider.class)
    private void startApp(IOSCapabilitiesModel model, String remoteUrl){

        //初始化webdriver
        driver = IOSSetCapabilitiesInvoker.getInstance().InitDriver(model,remoteUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterTest
    private void quit(){
        driver.quit();
    }

}
