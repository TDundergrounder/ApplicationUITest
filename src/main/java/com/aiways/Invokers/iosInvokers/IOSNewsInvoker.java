package com.aiways.Invokers.iosInvokers;

import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.androidModels.news.NewsDataModel;
import com.aiways.models.androidModels.news.NewsLocateModel;
import com.aiways.models.iosModels.loginOut.IOSLoginOutLocateModel;
import com.aiways.models.iosModels.news.IOSNewsLocateModel;
import com.aiways.models.iosModels.news.IOSNewsModel;
import com.aiways.utilities.AssertMethodsClass;
import com.aiways.utilities.DataGenera;
import com.aiways.utilities.SwipeTools.IOSSwipe;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class IOSNewsInvoker extends AbstractInvoker {

    public IOSNewsInvoker(){
        super(TestConstants.GROUP_NEWS);
    }

    public boolean isExistVideo;

    public boolean isExistImg;

    public boolean isTextArea;


    //进入详情页
    public void viewNewsDetail(IOSDriver<IOSElement> driver, IOSNewsLocateModel locateModel,int index) {
        try {
            driver.findElementByIosNsPredicate(locateModel.getHomeBtn_IosNsPredicate()).click();
            Thread.sleep(2000);
            List<IOSElement> iosElementList = driver.findElementsByXPath(locateModel.getXCUIElementTypeCells_xpath());
            iosElementList.get(index).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //查看详情的banner图
    public void viewNewsDetailBanner(IOSDriver<IOSElement> driver, IOSNewsLocateModel locateModel){
        try {
            List<IOSElement> imgElementsList = driver.findElementsByIosNsPredicate(locateModel.getImgElementsLis1t_IosNsPredicate());
            int imgListSize = imgElementsList.size();
            System.out.println("该页面共"+imgListSize+"个XCUIElementTypeImage");
            //点击展开banner图
            imgElementsList.get(1).click();
            Thread.sleep(2000);
            //点击收起banner图
            List<IOSElement> iosElements = driver.findElementsByIosNsPredicate(locateModel.getImgElementsList2_IosNsPredicate());
            System.out.println(iosElements.size());
            iosElements.get(iosElements.size()-1).click();
            Thread.sleep(2000);
            driver.findElementByAccessibilityId(locateModel.getBack_AccessibilityId()).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //添加评论
    public void addComment(IOSNewsModel dataModel,IOSNewsLocateModel locateModel,IOSDriver<IOSElement> driver){
        try {
//            new SwipeTool().SwipeUpToBottom(driver, "全部评论");
            Thread.sleep(2000);
            IOSElement InputAreaElement = driver.findElementByIosNsPredicate(locateModel.getInput_IosNsPredicate());
            InputAreaElement.click();
            List<IOSElement> elements = driver.findElementsByIosNsPredicate(locateModel.getXCUIElementTypeTextView_IosNsPredicate());
            elements.get(elements.size()-1).sendKeys(dataModel.getCommentContent().concat(new DataGenera().getTimeNow()));
            Thread.sleep(3000);
            List<IOSElement> btnElements = driver.findElementsByIosNsPredicate(locateModel.getCommitBtn_IosNsPredicate());
            System.out.println("完成btn有"+btnElements.size()+"个");
            btnElements.get(1).click();
            Thread.sleep(2000);
            driver.findElementByAccessibilityId(locateModel.getBack_AccessibilityId()).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //添加回复
    public void addReply(IOSNewsModel model,IOSNewsLocateModel locateModel,IOSDriver<IOSElement> driver){
        try {
            IOSSwipe iosSwipe = new IOSSwipe();
            iosSwipe.SwipeUpToBottom(driver,"回复");
            List<IOSElement> replyElements = driver.findElementsByIosNsPredicate("type == 'XCUIElementTypeButton' AND name == '回复' AND visible == true");
            System.out.println("【回复】共"+replyElements.size()+"个");
            replyElements.get(0).click();
            Thread.sleep(2000);
            driver.findElementByAccessibilityId(locateModel.getBack_AccessibilityId()).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
