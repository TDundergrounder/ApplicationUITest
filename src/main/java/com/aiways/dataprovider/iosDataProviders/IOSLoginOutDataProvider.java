package com.aiways.dataprovider.iosDataProviders;

import com.aiways.Invokers.androidInvokers.LoginInvoker;
import com.aiways.Invokers.iosInvokers.IOSLoginOutInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class IOSLoginOutDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String, String> _iosloginoutData = _data.get(TestConstants.GROUP_LOGINOUT);

    protected static HashMap<String,String> _iosloginoutlocateData = _locateData.get(TestConstants.GROUP_LOGINOUT);

    protected static IOSLoginOutModel getDefaultLoginModel(ITestContext context){

        IOSLoginOutInvoker invoker = (IOSLoginOutInvoker) context.getAttribute(IOSLoginOutInvoker.class.getTypeName());
        if(null == invoker){
            Assert.fail();
        }

        IOSLoginOutModel model = new IOSLoginOutModel(
                _iosloginoutData.get("mobile"),
                _iosloginoutData.get("code")
        );

        return model;
    }

    protected static IOSLoginOutLocateModel getDefaultLocateLoginModel(ITestContext context){

        IOSLoginOutInvoker invoker = (IOSLoginOutInvoker) context.getAttribute(IOSLoginOutInvoker.class.getTypeName());
        if(null == invoker){
            Assert.fail();
        }

        IOSLoginOutLocateModel locateModel = new IOSLoginOutLocateModel(
                _iosloginoutlocateData.get("mine_xpath"),
                _iosloginoutlocateData.get("isLogin_name"),
                _iosloginoutlocateData.get("reglogin_IosNsPredicate"),
                _iosloginoutlocateData.get("input_IosNsPredicate"),
                _iosloginoutlocateData.get("loginBtn_IosNsPredicate"),
                _iosloginoutlocateData.get("settingsBtn_IosNsPredicate"),
                _iosloginoutlocateData.get("logoutBtn_IosNsPredicate"),
                _iosloginoutlocateData.get("confirmlogoutBtn_IosNsPredicate")
        );

        return locateModel;
    }

    public static final String DATA_GETLOGINOUTDATA = "GetLoginOutData";

    @DataProvider(name = DATA_GETLOGINOUTDATA)
    public static Object[][] getLoginOutData(ITestContext context) {

        return new Object[][]{
                {getDefaultLoginModel(context),getDefaultLocateLoginModel(context)},
                {getDefaultLoginModel(context),getDefaultLocateLoginModel(context)}
        };
    }
}
