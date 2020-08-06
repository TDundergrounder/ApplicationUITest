package com.aiways.models.androidModels.topics;

import com.google.gson.Gson;

public class TopicsLocateModel {

    private String topicsTab_xpath;

    private String topicBtn_xpath;

    private String voteBtn_xpath;

    private String topicsPicture_id;

    public String getTopicsTab_xpath() {
        return topicsTab_xpath;
    }

    public void setTopicsTab_xpath(String topicsTab_xpath) {
        this.topicsTab_xpath = topicsTab_xpath;
    }

    public String getTopicBtn_xpath() {
        return topicBtn_xpath;
    }

    public void setTopicBtn_xpath(String topicBtn_xpath) {
        this.topicBtn_xpath = topicBtn_xpath;
    }

    public String getVoteBtn_xpath() {
        return voteBtn_xpath;
    }

    public void setVoteBtn_xpath(String voteBtn_xpath) {
        this.voteBtn_xpath = voteBtn_xpath;
    }

    public String getTopicsPicture_id() {
        return topicsPicture_id;
    }

    public void setTopicsPicture_id(String topicsPicture_id) {
        this.topicsPicture_id = topicsPicture_id;
    }

    public TopicsLocateModel(String topicsTab_xpath, String topicBtn_xpath, String voteBtn_xpath, String topicsPicture_id) {
        this.topicsTab_xpath = topicsTab_xpath;
        this.topicBtn_xpath = topicBtn_xpath;
        this.voteBtn_xpath = voteBtn_xpath;
        this.topicsPicture_id = topicsPicture_id;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
