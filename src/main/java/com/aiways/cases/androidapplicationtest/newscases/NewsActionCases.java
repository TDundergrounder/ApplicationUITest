package com.aiways.cases.androidapplicationtest.newscases;

import com.aiways.Invokers.androidInvokers.SetCapabilitiesInvoker;
import com.aiways.cases.androidapplicationtest.AbstractTestCase;
import com.aiways.config.TestConfiguration;
import com.aiways.constants.TestConstants;
import com.aiways.dataprovider.androidDataProviders.CommonDataProvider;
import com.aiways.dataprovider.androidDataProviders.NewsDataProvider;
import com.aiways.models.androidModels.Common.CommonModel;
import com.aiways.models.androidModels.capability.AndroidCapabilitiesModel;
import com.aiways.models.androidModels.news.NewsDataModel;
import com.aiways.models.androidModels.news.NewsLocateModel;
import com.aiways.utilities.ClientGroup;
import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;

@Test(groups = TestConstants.GROUP_NEWS, singleThreaded = true)
@ClientGroup(TestConstants.GROUP_NEWS)
public class NewsActionCases extends AbstractTestCase {

    Logger _log = Logger.getLogger(NewsActionCases.class);

    AndroidDriver<AndroidElement> driver = null;

    Boolean is_login;

    String Name;

    int waitTime = 5;

    int newsIndex = 0;

    @BeforeTest
    private void start() {
        try {
            DesiredCapabilities iosCapabilities = new DesiredCapabilities();

            String remoteUrl = TestConfiguration.instance().get_appium_remoteServer();

            Map<String, String> map = new HashMap<String, String>();

            map = TestConfiguration.instance().get_capabilitiesMap();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                iosCapabilities.setCapability(entry.getKey(), entry.getValue());
            }
            driver = new AndroidDriver<AndroidElement>(new URL(remoteUrl), iosCapabilities);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    //传入参数,赋值is_login
    @Test(dataProvider = CommonDataProvider.DATA_GETCOMMONDATA, dataProviderClass = CommonDataProvider.class,
            priority = 0)
    private void ifLogin(CommonModel model) {
        this.is_login = _commonInvoker.isLogin(model, driver);
        Assert.assertTrue(is_login, "已登录");
//        if (this.is_login) {
//            //当前是已登录状态
//            _log.info("当前已登录");
//            System.out.println("当前已登录");
//        } else {
//            //当前未登录
//            System.out.println("当前未登录");
//            _log.info("当前未登录");
//        }

    }

    //执行用例,查看详情页banner
    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
            priority = 1)
    private void runNewsAction1(NewsDataModel dataModel, NewsLocateModel locateModel) {
        //查看第一条news
        _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
        //点击查看banner图
        _newsInvoker.viewNewsDetailBanner(dataModel, locateModel, driver);
        //press back
        KeyEvent event = new KeyEvent(BACK);
        driver.pressKey(event);
    }


    //当前资讯详情页的类型（图片/视频/纯文本）
    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
            priority = 2)
    private void runNewsAction2(NewsDataModel dataModel, NewsLocateModel locateModel) {
        _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
        _newsInvoker.viewNewsDetailContent(dataModel, locateModel, driver);

        String contentFlag = "当前详情页为纯文字";
        if (_newsInvoker.isExistVideo) {
            Assert.assertTrue(_newsInvoker.isExistVideo, "当前详情页内容为视频");
            System.out.println("当前详情页内容为视频");
        } else if (_newsInvoker.isExistImg) {
            Assert.assertTrue(_newsInvoker.isExistImg, "当前详情页内容为图片");
            System.out.println("当前详情页内容为图片");
        } else {
            Assert.assertEquals(contentFlag, "当前详情页为纯文字");
            System.out.println("当前详情页为纯文字");
        }

        KeyEvent event = new KeyEvent(BACK);
        driver.pressKey(event);
    }


    //对详情页添加评论
    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
            priority = 3)
    private void runNewsAction3(NewsDataModel dataModel, NewsLocateModel locateModel) {
        if (this.is_login) {
            //当前是已登录状态
            _log.info("当前已登录，继续执行添加评论");
            System.out.println("当前已登录，继续执行添加评论");
            _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
            _newsInvoker.addComment(dataModel, locateModel, driver);
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
        } else {
            //当前未登录
            System.out.println("当前未登录，退出测试");
            _log.info("当前未登录,退出测试");
        }
    }

    //点赞or取消点赞回复
    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
            priority = 4)
    private void runNewsAction4(NewsDataModel dataModel, NewsLocateModel locateModel) {
        if (this.is_login) {
            //当前是已登录状态
            _log.info("当前已登录，继续执行点赞评论");
            System.out.println("当前已登录，继续执行点赞评论");
            _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
            _newsInvoker.likeComment(dataModel, locateModel,driver);
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
        } else {
            //当前未登录
            System.out.println("当前未登录，退出测试");
            _log.info("当前未登录,退出测试");
        }

    }

    //添加详情页的评论回复
//    @Test(dataProvider = NewsDataProvider.DATA_GETNEWSTESTDATA, dataProviderClass = NewsDataProvider.class,
//            priority = 5)
//    private void runNewsAction5(NewsDataModel dataModel, NewsLocateModel locateModel) {
//        if (this.is_login) {
//            //当前是已登录状态
//            _log.info("当前已登录，继续执行添加回复");
//            System.out.println("当前已登录，继续执行添加回复");
//            _newsInvoker.viewNewsDetail(dataModel, locateModel, driver, newsIndex);
//            this.Name = _commonInvoker.userName;
//            System.out.println("Name:"+this.Name);
//            _newsInvoker.addReply(dataModel, locateModel,driver,Name);
//            KeyEvent event = new KeyEvent(BACK);
//            driver.pressKey(event);
//        } else {
//            //当前未登录
//            System.out.println("当前未登录，退出测试");
//            _log.info("当前未登录,退出测试");
//        }
//
//    }


    @AfterTest
    private void quit() {
        driver.quit();
    }
}
