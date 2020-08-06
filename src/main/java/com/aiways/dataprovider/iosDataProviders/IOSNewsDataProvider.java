package com.aiways.dataprovider.iosDataProviders;

import com.aiways.Invokers.iosInvokers.IOSNewsInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.iosModels.news.IOSNewsLocateModel;
import com.aiways.models.iosModels.news.IOSNewsModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class IOSNewsDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String,String> _iosnewsData = _data.get(TestConstants.GROUP_NEWS);

    protected static HashMap<String,String> _iosnewslocateData = _locateData.get(TestConstants.GROUP_NEWS);

    protected static IOSNewsModel getDefaultNewsModel(ITestContext context) {

        IOSNewsInvoker invoker = (IOSNewsInvoker) context.getAttribute(IOSNewsInvoker.class.getTypeName());
        if (null == invoker) {
            Assert.fail();
        }

        IOSNewsModel iosNewsModel = new IOSNewsModel(
                _iosnewsData.get("CommentContent"),
                _iosnewsData.get("ComReplyContent")
        );

        return iosNewsModel;
    }

    protected static IOSNewsLocateModel getDefaultNewsLocateModel(ITestContext iTestContext){
        IOSNewsInvoker invoker = (IOSNewsInvoker) iTestContext.getAttribute(IOSNewsInvoker.class.getTypeName());
        if (null == invoker) {
            Assert.fail();
        }

        IOSNewsLocateModel locateModel = new IOSNewsLocateModel(
                _iosnewslocateData.get("HomeBtn_IosNsPredicate"),
                _iosnewslocateData.get("XCUIElementTypeCells_xpath"),
                _iosnewslocateData.get("back_AccessibilityId"),
                _iosnewslocateData.get("imgElementsLis1t_IosNsPredicate"),
                _iosnewslocateData.get("imgElementsList2_IosNsPredicate")
        );

        return locateModel;
    }

    public static final String DATA_GETLOGINOUTDATA = "GetNewsData";

    @DataProvider(name = DATA_GETLOGINOUTDATA)
    public static Object[][] getLoginOutData(ITestContext context) {

        return new Object[][]{
                {getDefaultNewsModel(context),getDefaultNewsLocateModel(context)},
                {getDefaultNewsModel(context),getDefaultNewsLocateModel(context)}
        };
    }
}
