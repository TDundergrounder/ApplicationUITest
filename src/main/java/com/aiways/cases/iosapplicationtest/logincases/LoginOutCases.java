package com.aiways.cases.iosapplicationtest.logincases;

import com.aiways.cases.iosapplicationtest.AbstractIOSTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.dataprovider.iosDataProviders.IOSLoginOutDataProvider;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutModel;
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

public class LoginOutCases extends AbstractIOSTestCase {

    IOSDriver<IOSElement> driver = null;

    int waitTime = 3;

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
            driver = new IOSDriver<IOSElement>(new URL(remoteUrl), iosCapabilities);
            driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = IOSLoginOutDataProvider.DATA_GETLOGINOUTDATA, dataProviderClass = IOSLoginOutDataProvider.class)
    private void RunLoginOut(IOSLoginOutModel model, IOSLoginOutLocateModel loc_model) {

        _iosloginoutInvoker.loginOut(model, loc_model, driver);

    }

    @AfterTest
    private void quit() {
        driver.quit();
    }

}

