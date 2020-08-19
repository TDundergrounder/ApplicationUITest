package com.aiways.cases.androidapplicationtest.logincases;

import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.androidDataProviders.LoginOutDataProvider;
import com.aiways.models.androidModels.login_out.LoginOutLocateModel;
import com.aiways.models.androidModels.login_out.LoginOutModel;
import com.aiways.utilities.ClientGroup;
import com.aiways.utilities.DataGenera;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Test(groups = TestConstants.GROUP_LOGINOUT, singleThreaded = true)
@ClientGroup(TestConstants.GROUP_LOGINOUT)
public class LoginOutCases extends AbstractTestCase {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    private void start() {
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL(TestConfiguration.instance().get_appium_remoteServer()),
                    new DataGenera().getIosCapabilities(TestConfiguration.instance().get_capabilitiesMap())
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(dataProvider = LoginOutDataProvider.DATA_GETLOGINOUTDATA, dataProviderClass = LoginOutDataProvider.class)
    private void RunLoginOut(LoginOutModel model, LoginOutLocateModel loc_model) {

        _loginInvoker.loginOut(model, loc_model, driver);
    }

    @AfterTest
    private void quit() {
        driver.quit();
    }

}
