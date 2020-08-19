package com.aiways.cases.iosapplicationtest.logincases;

import com.aiways.cases.iosapplicationtest.AbstractIOSTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.dataprovider.iosDataProviders.IOSLoginOutDataProvider;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutModel;
import com.aiways.utilities.DataGenera;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSLoginOutCases extends AbstractIOSTestCase {

    IOSDriver<IOSElement> driver = null;

    int waitTime = 3;

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

    @Test(dataProvider = IOSLoginOutDataProvider.DATA_GETLOGINOUTDATA, dataProviderClass = IOSLoginOutDataProvider.class)
    private void RunLoginOut(IOSLoginOutModel model, IOSLoginOutLocateModel loc_model) {

        _iosloginoutInvoker.loginOut(model, loc_model, driver);

    }

    @AfterTest
    private void quit() {
        driver.quit();
    }

}

