package com.aiways.dataprovider.androidDataProviders;

import com.aiways.config.TestConfiguration;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.androidModels.capability.AndroidCapabilitiesModel;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class CapabilitiesDataprovider extends AbstractTestDataProvider {

    protected static HashMap<String, String> _capabilitiesData = _data.get(TestConstants.GROUP_CAPABILITIES);

    protected static AndroidCapabilitiesModel getDefaultCapModel(ITestContext testContext){

        AndroidCapabilitiesModel model = new AndroidCapabilitiesModel(
                _capabilitiesData.get("platformName"),
                _capabilitiesData.get("platformVersion"),
                _capabilitiesData.get("deviceName"),
                _capabilitiesData.get("appPackage"),
                _capabilitiesData.get("appActivity"),
                _capabilitiesData.get("noReset"),
                _capabilitiesData.get("resetKeyboard")
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
                {getDefaultCapModel(context),getRemote()},
                {getDefaultCapModel(context),getRemote()}
        };
    }
}
