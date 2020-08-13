package com.aiways.cases.androidapplicationtest.logincases;

import com.aiways.Invokers.androidInvokers.SetCapabilitiesInvoker;
import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.constants.TestCapilitiesConstants;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.androidDataProviders.LoginOutDataProvider;
import com.aiways.models.androidModels.capability.AndroidCapabilitiesModel;
import com.aiways.models.androidModels.login_out.LoginOutLocateModel;
import com.aiways.models.androidModels.login_out.LoginOutModel;
import com.aiways.utilities.ClientGroup;
import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Test(groups = TestConstants.GROUP_LOGINOUT,singleThreaded = true)
@ClientGroup(TestConstants.GROUP_LOGINOUT)
public class LoginOutCases extends AbstractTestCase {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    private void start() {
        try {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();

            String remoteUrl = TestConfiguration.instance().get_appium_remoteServer();

            Map<String, String> map = new HashMap<String, String>();

            map = TestConfiguration.instance().get_capabilitiesMap();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                iosCapabilities.setCapability(entry.getKey(), entry.getValue());
            }
            driver = new AndroidDriver<AndroidElement>(new URL(remoteUrl), iosCapabilities);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = LoginOutDataProvider.DATA_GETLOGINOUTDATA,dataProviderClass = LoginOutDataProvider.class)
private void RunLoginOut(LoginOutModel model, LoginOutLocateModel loc_model){

    _loginInvoker.loginOut(model,loc_model,driver);
}

    @AfterTest
    private void quit(){
        driver.quit();
    }

}
