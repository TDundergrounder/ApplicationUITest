package com.aiways.Invokers.iosInvokers;

import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.iosModels.news.IOSNewsLocateModel;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class IOSNewsInvoker extends AbstractInvoker {

    public IOSNewsInvoker(){
        super(TestConstants.GROUP_NEWS);
    }


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
}
