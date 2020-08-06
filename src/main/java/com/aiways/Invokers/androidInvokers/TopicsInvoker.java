package com.aiways.Invokers.androidInvokers;

import com.aiways.Invokers.AbstractInvoker;
import com.aiways.constants.SpringConstants;
import com.aiways.constants.TestConstants;
import com.aiways.models.androidModels.topics.TopicsDataModel;
import com.aiways.models.androidModels.topics.TopicsLocateModel;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;

@Component
@Scope(SpringConstants.SCOPE_SINGLETON)
public class TopicsInvoker extends AbstractInvoker {

    public TopicsInvoker(){
        super(TestConstants.GROUP_NEWS);
    }

    //查看话题详情
    public void viewDiscussDetail(TopicsDataModel dataModel, TopicsLocateModel locateModel,
                                  AndroidDriver<AndroidElement> driver, int topicIndex){
        try {
            //点击话题的title
            driver.findElementByXPath(locateModel.getTopicsTab_xpath()).click();
            driver.findElementByXPath(locateModel.getTopicBtn_xpath()).click();
            List<AndroidElement> topicList = driver.findElementsById(locateModel.getTopicsPicture_id());
            topicList.get(topicIndex).click();
            KeyEvent event = new KeyEvent(BACK);
            driver.pressKey(event);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //查看投票详情
    public void viewVoteDetail(TopicsDataModel dataModel, TopicsLocateModel locateModel,
                               AndroidDriver<AndroidElement> driver, int voteIndex){
    try{
        driver.findElementByXPath(locateModel.getTopicsTab_xpath()).click();
        driver.findElementByXPath(locateModel.getVoteBtn_xpath()).click();
        List<AndroidElement> voteList = driver.findElementsById(locateModel.getTopicsPicture_id());
        voteList.get(voteIndex).click();
        KeyEvent event = new KeyEvent(BACK);
        driver.pressKey(event);
        Thread.sleep(2000);
    }catch (InterruptedException e) {
        e.printStackTrace();
    }


    }


}
