package com.aiways.cases.androidapplicationtest.topicscases;

import com.aiways.cases.androidapplicationtest.AbstractTestCase;

import com.aiways.config.TestConfiguration;
import com.aiways.utilities.DataGenera;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TopicsActionCases extends AbstractTestCase {

    AndroidDriver<AndroidElement> driver =null;

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


}
