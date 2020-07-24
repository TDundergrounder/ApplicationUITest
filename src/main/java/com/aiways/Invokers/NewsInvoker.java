package com.aiways.Invokers;

import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.news.NewsDataModel;
import com.aiways.models.news.NewsLocateModel;
import com.aiways.utilities.AssertMethodsClass;
import com.aiways.utilities.DataGenera;
import com.aiways.utilities.SwipeTool;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.appium.java_client.android.nativekey.AndroidKey.*;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class NewsInvoker extends AbstractInvoker {

    public NewsInvoker(){
        super(TestConstants.GROUP_NEWS);
    }

    public boolean isExistVideo;

    public boolean isExistImg;

    public boolean isTextArea;


    public void viewNewsDetail(NewsDataModel dataModel, NewsLocateModel locateModel,
                                AndroidDriver<AndroidElement> driver,int NewsIndex) {
        try {
            //点击首页
            driver.findElementByXPath(locateModel.getHomePage_xpath()).click();
            Thread.sleep(2000);
            //点击第一条news
            List<AndroidElement> newsgroup = driver.findElementsById(locateModel.getNewsViewGroup_id());
            newsgroup.get(NewsIndex).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void viewNewsDetailBanner(NewsDataModel dataModel, NewsLocateModel locateModel,
                                     AndroidDriver<AndroidElement> driver) {
        try {
            //点击详情的banner图查看
            AndroidElement detailBanner = driver.findElementByXPath(locateModel.getNewsDetailBanner_xpath());
            detailBanner.click();
            Thread.sleep(2000);
            //KeyEvent是一个枚举类，pressKey的构造函数需要传入一个对应的枚举类型，如HOME->3 BAck->4
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void viewNewsDetailContent(NewsDataModel dataModel,NewsLocateModel locateModel,AndroidDriver<AndroidElement> driver){
        this.isExistVideo = new AssertMethodsClass()
                .byElementIsExist(By.xpath(locateModel.getNewsDetailVideo_xpath()),driver);
        this.isExistImg = new AssertMethodsClass()
                .byElementIsExist(By.xpath(locateModel.getNewsDetailImg_xpath()),driver);
        this.isTextArea = new AssertMethodsClass()
                .byElementIsExist(By.xpath(locateModel.getNewsDetailText_xpath()),driver);
    }


//    public void viewCommentList(NewsDataModel dataModel,NewsLocateModel locateModel,AndroidDriver<AndroidElement> driver){
//        try {
//            new SwipeTool().SwipeUpToBottom(driver, "全部评论");
//            KeyEvent event = new KeyEvent(BACK);
//            driver.pressKey(event);
//            Thread.sleep(2000);
//            String UiSelectorStr = "resourceId('app').ChidSelector(new UiSelector().className('android.view.View')).index(3).ChidSelector(new UiSelector().className('android.widget.ListView')).ChidSelector(new UiSelector().className('android.view.View'))";
//            List<AndroidElement> elements = driver
//                    .findElementsByAndroidUIAutomator(UiSelectorStr);
//            int size = elements.size();
//            System.out.println(size);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public void addComment(NewsDataModel dataModel,NewsLocateModel locateModel,AndroidDriver<AndroidElement> driver){
        try {
//            new SwipeTool().SwipeUpToBottom(driver, "全部评论");
//            Thread.sleep(2000);
            AndroidElement InputAreaElement = driver.findElementByXPath(locateModel.getComInputTextArea_xpath());
            InputAreaElement.click();
            AndroidElement EditBoxElement = driver.findElementByXPath(locateModel.getCommentEditBox_xpath());
            EditBoxElement.sendKeys(dataModel.getCommentContent().concat(new DataGenera().getTimeNow()));
            Thread.sleep(3000);
            driver.findElementByXPath(locateModel.getCommitCommentBtn_xpath()).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void addReply(NewsDataModel dataModel,NewsLocateModel locateModel,AndroidDriver<AndroidElement> driver,String endStr){
        try {
            new SwipeTool().SwipeUpToBottom(driver, "全部评论");
            Thread.sleep(2000);
            AndroidElement replyBtn = driver.findElementByXPath(locateModel.getCommentReply_xpath());
            replyBtn.click();
            Thread.sleep(2000);
            AndroidElement replyEditbox = driver.findElementByXPath(locateModel.getReplyEditBox_xpath());
            replyEditbox.sendKeys(dataModel.getComReplyContent().concat(new DataGenera().getTimeNow()));
            driver.findElementByXPath(locateModel.getCommitReplyBtn_xpath()).click();
            Thread.sleep(3000);
            new SwipeTool().SwipeUpToBottom(driver,endStr);
            Thread.sleep(3000);
            System.out.println(locateModel.getDeleteReply_xpath());
            driver.findElementByXPath(locateModel.getDeleteReply_xpath()).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void likeComment(NewsDataModel dataModel,NewsLocateModel locateModel,AndroidDriver driver){
        try {
            Thread.sleep(2000);
            new SwipeTool().SwipeUpToBottom(driver, "全部评论");
            //点赞
            List<AndroidElement> elements = driver.findElementsByClassName(locateModel.getAndroidBtn_classname());
            elements.get(6).click();
            Thread.sleep(3000);
            //取消点赞
            elements.get(6).click();
            Thread.sleep(1000);
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
