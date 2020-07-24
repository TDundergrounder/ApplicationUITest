package com.aiways.cases.androidapplicationtest.capabilitiescases;

import com.aiways.Invokers.SetCapabilitiesInvoker;
import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.CapabilitiesDataprovider;
import com.aiways.models.capability.AndroidCapabilitiesModel;
import com.aiways.utilities.ClientGroup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Test(groups = TestConstants.GROUP_CAPABILITIES,singleThreaded = true )
@ClientGroup(TestConstants.GROUP_CAPABILITIES)
public class GetCapCases extends AbstractTestCase {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    private void startTest(){
        System.out.println("start running!");

    }


    @Test(dataProvider = CapabilitiesDataprovider.DATA_GETCAPABILITIES,dataProviderClass = CapabilitiesDataprovider.class)
    private void startApp(AndroidCapabilitiesModel model,String remoteUrl){

        //初始化webdriver
        driver = SetCapabilitiesInvoker.getInstance().InitDriver(model,remoteUrl);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    private void quit(){
        driver.quit();
    }

}
