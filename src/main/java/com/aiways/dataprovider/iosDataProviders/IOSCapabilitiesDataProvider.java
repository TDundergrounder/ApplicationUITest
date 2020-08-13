package com.aiways.dataprovider.iosDataProviders;

import com.aiways.config.TestConfiguration;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.androidModels.capability.AndroidCapabilitiesModel;
import com.aiways.models.iosModels.capability.IOSCapabilitiesModel;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class IOSCapabilitiesDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String, String> _ioscapabilitiesData = _data.get(TestConstants.GROUP_CAPABILITIES);

    protected static IOSCapabilitiesModel getIOSDefaultCapModel(ITestContext testContext){

        IOSCapabilitiesModel model = new IOSCapabilitiesModel(
                _ioscapabilitiesData.get("platformName"),
                _ioscapabilitiesData.get("udid"),
                _ioscapabilitiesData.get("platformVersion"),
                _ioscapabilitiesData.get("deviceName"),
                _ioscapabilitiesData.get("automationName"),
                _ioscapabilitiesData.get("bundleId")
        );

        return model;
    }

    protected static String getRemote(){

        return TestConfiguration.instance().get_appium_remoteServer();
    }

    public static final String DATA_GETCAPABILITIES = "GetCapabilities";

    @DataProvider(name = DATA_GETCAPABILITIES)
    public static Object[][] getCapabilitiesData(ITestContext context) {

        return new Object[][]{
                {getIOSDefaultCapModel(context),getRemote()},
                {getIOSDefaultCapModel(context),getRemote()}
        };
    }
}
