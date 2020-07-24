package com.aiways.dataprovider;

import com.aiways.Invokers.NewsInvoker;
import com.aiways.constants.TestConstants;
import com.aiways.models.news.NewsDataModel;
import com.aiways.models.news.NewsLocateModel;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class NewsDataProvider extends AbstractTestDataProvider {

    protected static HashMap<String ,String>  _newsData = _data.get(TestConstants.GROUP_NEWS);

    protected static HashMap<String,String> _newslocateData = _locateData.get(TestConstants.GROUP_NEWS);

    protected static NewsDataModel getDefaultNewsDataModel(ITestContext context){

        NewsInvoker invoker = (NewsInvoker)context.getAttribute(NewsInvoker.class.getTypeName());

        if (null == invoker) {
            Assert.fail();
        }

        NewsDataModel model = new NewsDataModel(
                _newsData.get("CommentContent"),
                _newsData.get("ComReplyContent")
        );
        return model;
    }

    protected static NewsLocateModel getDefaultNewsLocateModel(ITestContext context){

        NewsInvoker newsinvoker = (NewsInvoker)context.getAttribute(NewsInvoker.class.getTypeName());

        if (null == newsinvoker) {
            Assert.fail();
        }

        NewsLocateModel locateModel = new NewsLocateModel(
                _newslocateData.get("homePage_xpath"),
                _newslocateData.get("newsViewGroup_id"),
                _newslocateData.get("newsDetailBanner_xpath"),
                _newslocateData.get("newsBannerDetail_xpath"),
                _newslocateData.get("newsDetailImg_xpath"),
                _newslocateData.get("newsDetailVideo_xpath"),
                _newslocateData.get("HotComment_xpath"),
                _newslocateData.get("AllComent_xpath"),
                _newslocateData.get("CommentReply_xpath"),
                _newslocateData.get("ReplyEditBox_xpath"),
                _newslocateData.get("WriteComment_xpath"),
                _newslocateData.get("LikeNewsBtn_xpath"),
                _newslocateData.get("ComInputTextArea_xpath"),
                _newslocateData.get("CommentEditBox_xpath"),
                _newslocateData.get("CommitCommentBtn_xpath"),
                _newslocateData.get("CommitReplyBtn_xpath"),
                _newslocateData.get("newsDetailText_xpath"),
                _newslocateData.get("DeleteReply_xpath"),
                _newslocateData.get("likeComment_xpath"),
                _newslocateData.get("androidBtn_classname")
        );
        return locateModel;
    }

    public static final String DATA_GETNEWSTESTDATA = "GetNewsTestData";

    @DataProvider(name = DATA_GETNEWSTESTDATA)
    public static Object[][] geDefaulttNewsTestData(ITestContext context) {

        return new Object[][]{
                {getDefaultNewsDataModel(context),getDefaultNewsLocateModel(context)},
                {getDefaultNewsDataModel(context),getDefaultNewsLocateModel(context)}
        };
    }
}
