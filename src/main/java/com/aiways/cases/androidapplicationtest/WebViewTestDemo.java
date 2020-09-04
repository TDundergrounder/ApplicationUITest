package com.aiways.cases.androidapplicationtest;

import com.aiways.cases.androidapplicationtest.newscases.NewsActionCases;
import com.aiways.config.TestConfiguration;
import com.aiways.dataprovider.androidDataProviders.NewsDataProvider;
import com.aiways.models.androidModels.news.NewsDataModel;
import com.aiways.models.androidModels.news.NewsLocateModel;
import com.aiways.utilities.DataGenera;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;

public class WebViewTestDemo extends AbstractTestCase{

    AndroidDriver<AndroidElement> driver = null;

    int newsIndex = 0;

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

    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
            priority = 1)
    private void runNewsAction1(NewsDataModel dataModel, NewsLocateModel locateModel) {
        try {
            //查看第一条news
            _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



