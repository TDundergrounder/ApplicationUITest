package com.aiways.dataprovider.androidDataProviders;

import com.aiways.Invokers.androidInvokers.LoginInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.androidModels.login_out.LoginOutLocateModel;
import com.aiways.models.androidModels.login_out.LoginOutModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class LoginOutDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String,String> _loginOutData = _data.get(TestConstants.GROUP_LOGINOUT);

    protected static HashMap<String,String> _loginOutLocateData = _locateData.get(TestConstants.GROUP_LOGINOUT);

    protected static LoginOutModel getDefaultLoginDataModel(ITestContext testContext) {

        LoginInvoker invoker = (LoginInvoker) testContext.getAttribute(LoginInvoker.class.getTypeName());

        if (null == invoker) {
            Assert.fail();
        }

        LoginOutModel model = new LoginOutModel(
                _loginOutData.get("mobile"),
                _loginOutData.get("code")
        );
        return model;
    }


    protected static LoginOutLocateModel getDefaultLoginLocateDataModel(ITestContext testContext) {

        LoginInvoker invoker = (LoginInvoker)testContext.getAttribute(LoginInvoker.class.getTypeName());

        if (null == invoker) {
            Assert.fail();
        }

        LoginOutLocateModel model = new LoginOutLocateModel(
                _loginOutLocateData.get("isLoginTag_id"),
                _loginOutLocateData.get("mobile_xpath"),
                _loginOutLocateData.get("code_xpath"),
                _loginOutLocateData.get("loginBtn_id"),
                _loginOutLocateData.get("MineRelativeLayoutClass_name"),
                _loginOutLocateData.get("SettingRelativeLayoutClass_name"),
                _loginOutLocateData.get("confirmQuit_btn"),
                _loginOutLocateData.get("mine_xpath")
        );
        return model;
    }

    public static final String DATA_GETLOGINOUTDATA = "GetLoginOutData";

    @DataProvider(name = DATA_GETLOGINOUTDATA)
    public static Object[][] getLoginOutData(ITestContext context) {

        return new Object[][]{
                {getDefaultLoginDataModel(context),getDefaultLoginLocateDataModel(context)},
                {getDefaultLoginDataModel(context),getDefaultLoginLocateDataModel(context)}
        };
    }
}
