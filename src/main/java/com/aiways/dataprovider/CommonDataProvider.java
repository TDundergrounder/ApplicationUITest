package com.aiways.dataprovider;

import com.aiways.Invokers.CommonInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.models.Common.CommonModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class CommonDataProvider extends AbstractTestDataProvider{

    protected static HashMap<String,String> _commonData = _locateData.get(TestConstants.GROUP_COMMON);

    protected static CommonModel getDefaultCommonData(ITestContext iTestContext){

        CommonInvoker invoker = (CommonInvoker)iTestContext.getAttribute(CommonInvoker.class.getTypeName());

        if(null == invoker){
            Assert.fail();
        }

        CommonModel commonModel = new CommonModel(
                _commonData.get("isLoginTag_id"),
                _commonData.get("mine_xpath")
        );
        return commonModel;
    }

    public static final String DATA_GETCOMMONDATA = "GetCommonData";

    @DataProvider(name = DATA_GETCOMMONDATA)
    public static Object[][] geDefaultIsLoginId(ITestContext context) {

        return new Object[][]{
                {getDefaultCommonData(context)},
                {getDefaultCommonData(context)}
        };
    }
}
