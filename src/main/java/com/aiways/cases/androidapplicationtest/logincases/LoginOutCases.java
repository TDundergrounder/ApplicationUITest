package com.aiways.cases.androidapplicationtest.logincases;

import com.aiways.Invokers.SetCapabilitiesInvoker;
import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.LoginOutDataProvider;
import com.aiways.models.capability.AndroidCapabilitiesModel;
import com.aiways.models.login_out.LoginOutLocateModel;
import com.aiways.models.login_out.LoginOutModel;
import com.aiways.utilities.ClientGroup;
import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test(groups = TestConstants.GROUP_LOGINOUT,singleThreaded = true)
@ClientGroup(TestConstants.GROUP_LOGINOUT)
public class LoginOutCases extends AbstractTestCase {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    private void start(){
        String CapJsonStr = "{\n" +
                "  \"noReset\": true,\n" +
                "  \"resetKeyboard\": true,\n" +
                "  \"appActivity\": \"com.aiways.auto.business.SplashActivity\",\n" +
                "  \"appPackage\": \"com.aiways.auto\",\n" +
                "  \"deviceName\": \"HUAWEI_Aiways\",\n" +
                "  \"platformVersion\": \"10.0\",\n" +
                "  \"platformName\": \"Android\"\n" +
                "}";
        AndroidCapabilitiesModel model = new Gson().fromJson(CapJsonStr,AndroidCapabilitiesModel.class);
        driver = SetCapabilitiesInvoker.getInstance().InitDriver(model,"http://127.0.0.1:4723/wd/hub");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
