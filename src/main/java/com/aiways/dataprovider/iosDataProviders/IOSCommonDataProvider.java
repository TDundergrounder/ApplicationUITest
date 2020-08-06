package com.aiways.dataprovider.iosDataProviders;

import com.aiways.Invokers.iosInvokers.IOSCommonInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.iosModels.common.IOSCommonModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class IOSCommonDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String,String> _ioscommonData = _locateData.get(TestConstants.GROUP_COMMON);

    protected static IOSCommonModel getDefaultIOSCommonData(ITestContext iTestContext){

        IOSCommonInvoker invoker = (IOSCommonInvoker)iTestContext.getAttribute(IOSCommonInvoker.class.getTypeName());

        if(null == invoker){
            Assert.fail();
        }

        IOSCommonModel commonModel = new IOSCommonModel(
                _ioscommonData.get("mine_xpath"),
                _ioscommonData.get("isLogin_name")
        );
        return commonModel;
    }

    public static final String DATA_GETCOMMONDATA = "GetCommonData";

    @DataProvider(name = DATA_GETCOMMONDATA)
    public static Object[][] geDefaultIsLoginData(ITestContext context) {

        return new Object[][]{
                {getDefaultIOSCommonData(context)},
                {getDefaultIOSCommonData(context)}
        };
    }
}
