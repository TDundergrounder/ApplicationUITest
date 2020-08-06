package com.aiways.dataprovider.androidDataProviders;

import com.aiways.Invokers.androidInvokers.TopicsInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.AbstractTestDataProvider;
import com.aiways.models.androidModels.topics.TopicsDataModel;
import com.aiways.models.androidModels.topics.TopicsLocateModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class TopicsDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String ,String> _topicsData = _data.get(TestConstants.GROUP_TOPICS);

    protected static HashMap<String,String> _topicslocateData = _locateData.get(TestConstants.GROUP_TOPICS);

    protected static TopicsDataModel getDefaultTopicDataModel(ITestContext context){

        TopicsInvoker invoker = (TopicsInvoker)context.getAttribute(TopicsInvoker.class.getTypeName());

        if (null == invoker) {
            Assert.fail();
        }

        TopicsDataModel model = new TopicsDataModel();
        return model;
    }

    protected static TopicsLocateModel getDefaultTopicsLocateModel(ITestContext context){

        TopicsInvoker topicsInvoker = (TopicsInvoker)context.getAttribute(TopicsInvoker.class.getTypeName());

        if (null == topicsInvoker) {
            Assert.fail();
        }

        TopicsLocateModel locateModel = new TopicsLocateModel(
                _topicslocateData.get("topicsTab_xpath"),
                _topicslocateData.get("topicBtn_xpath"),
                _topicslocateData.get("voteBtn_xpath"),
                _topicslocateData.get("topicsPicture_id")
        );
        return locateModel;
    }

    public static final String DATA_GETNEWSTESTDATA = "GetTopicsTestData";

    @DataProvider(name = DATA_GETNEWSTESTDATA)
    public static Object[][] geDefaulttTopicTestData(ITestContext context) {

        return new Object[][]{
                {getDefaultTopicDataModel(context),getDefaultTopicsLocateModel(context)},
                {getDefaultTopicDataModel(context),getDefaultTopicsLocateModel(context)}
        };
    }
}
