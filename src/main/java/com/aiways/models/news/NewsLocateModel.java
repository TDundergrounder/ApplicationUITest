package com.aiways.models.news;

import com.google.gson.Gson;

import java.io.Serializable;

public class NewsLocateModel implements Serializable {

    private String homePage_xpath;

    private String newsViewGroup_id;

    private String newsDetailBanner_xpath;

    private String newsBannerDetail_xpath;

    private String newsDetailImg_xpath;

    private String newsDetailVideo_xpath;

    private String HotComment_xpath;

    private String AllComent_xpath;

    private String CommentReply_xpath;

    private String ReplyEditBox_xpath;

    private String WriteComment_xpath;

    private String LikeNewsBtn_xpath;

    private String ComInputTextArea_xpath;

    private String CommentEditBox_xpath;

    private String CommitCommentBtn_xpath;

    private String CommitReplyBtn_xpath;

    private String newsDetailText_xpath;

    private String DeleteReply_xpath;

    private String likeComment_xpath;

    private String androidBtn_classname;

    public String getHomePage_xpath() {
        return homePage_xpath;
    }

    public void setHomePage_xpath(String homePage_xpath) {
        this.homePage_xpath = homePage_xpath;
    }

    public String getNewsViewGroup_id() {
        return newsViewGroup_id;
    }

    public void setNewsViewGroup_id(String newsViewGroup_id) {
        this.newsViewGroup_id = newsViewGroup_id;
    }

    public String getNewsDetailBanner_xpath() {
        return newsDetailBanner_xpath;
    }

    public void setNewsDetailBanner_xpath(String newsDetailBanner_xpath) {
        this.newsDetailBanner_xpath = newsDetailBanner_xpath;
    }

    public String getNewsBannerDetail_xpath() {
        return newsBannerDetail_xpath;
    }

    public void setNewsBannerDetail_xpath(String newsBannerDetail_xpath) {
        this.newsBannerDetail_xpath = newsBannerDetail_xpath;
    }

    public String getNewsDetailImg_xpath() {
        return newsDetailImg_xpath;
    }

    public void setNewsDetailImg_xpath(String newsDetailImg_xpath) {
        this.newsDetailImg_xpath = newsDetailImg_xpath;
    }

    public String getNewsDetailVideo_xpath() {
        return newsDetailVideo_xpath;
    }

    public void setNewsDetailVideo_xpath(String newsDetailVideo_xpath) {
        this.newsDetailVideo_xpath = newsDetailVideo_xpath;
    }

    public String getHotComment_xpath() {
        return HotComment_xpath;
    }

    public void setHotComment_xpath(String hotComment_xpath) {
        HotComment_xpath = hotComment_xpath;
    }

    public String getAllComent_xpath() {
        return AllComent_xpath;
    }

    public void setAllComent_xpath(String allComent_xpath) {
        AllComent_xpath = allComent_xpath;
    }

    public String getCommentReply_xpath() {
        return CommentReply_xpath;
    }

    public void setCommentReply_xpath(String commentReply_xpath) {
        CommentReply_xpath = commentReply_xpath;
    }

    public String getReplyEditBox_xpath() {
        return ReplyEditBox_xpath;
    }

    public void setReplyEditBox_xpath(String replyEditBox_xpath) {
        ReplyEditBox_xpath = replyEditBox_xpath;
    }

    public String getWriteComment_xpath() {
        return WriteComment_xpath;
    }

    public void setWriteComment_xpath(String writeComment_xpath) {
        WriteComment_xpath = writeComment_xpath;
    }

    public String getLikeNewsBtn_xpath() {
        return LikeNewsBtn_xpath;
    }

    public void setLikeNewsBtn_xpath(String likeNewsBtn_xpath) {
        LikeNewsBtn_xpath = likeNewsBtn_xpath;
    }

    public String getComInputTextArea_xpath() {
        return ComInputTextArea_xpath;
    }

    public void setComInputTextArea_xpath(String comInputTextArea_xpath) {
        ComInputTextArea_xpath = comInputTextArea_xpath;
    }

    public String getCommentEditBox_xpath() {
        return CommentEditBox_xpath;
    }

    public void setCommentEditBox_xpath(String commentEditBox_xpath) {
        CommentEditBox_xpath = commentEditBox_xpath;
    }

    public String getCommitCommentBtn_xpath() {
        return CommitCommentBtn_xpath;
    }

    public void setCommitCommentBtn_xpath(String commitCommentBtn_xpath) {
        CommitCommentBtn_xpath = commitCommentBtn_xpath;
    }

    public String getCommitReplyBtn_xpath() {
        return CommitReplyBtn_xpath;
    }

    public void setCommitReplyBtn_xpath(String commitReplyBtn_xpath) {
        CommitReplyBtn_xpath = commitReplyBtn_xpath;
    }

    public String getNewsDetailText_xpath() {
        return newsDetailText_xpath;
    }

    public void setNewsDetailText_xpath(String newsDetailText_xpath) {
        this.newsDetailText_xpath = newsDetailText_xpath;
    }

    public String getDeleteReply_xpath() {
        return DeleteReply_xpath;
    }

    public void setDeleteReply_xpath(String deleteReply_xpath) {
        DeleteReply_xpath = deleteReply_xpath;
    }

    public String getLikeComment_xpath() {
        return likeComment_xpath;
    }

    public void setLikeComment_xpath(String likeComment_xpath) {
        this.likeComment_xpath = likeComment_xpath;
    }

    public String getAndroidBtn_classname() {
        return androidBtn_classname;
    }

    public void setAndroidBtn_classname(String androidBtn_classname) {
        this.androidBtn_classname = androidBtn_classname;
    }

    public NewsLocateModel(String homePage_xpath, String newsViewGroup_id, String newsDetailBanner_xpath, String newsBannerDetail_xpath, String newsDetailImg_xpath, String newsDetailVideo_xpath, String hotComment_xpath, String allComent_xpath, String commentReply_xpath, String replyEditBox_xpath, String writeComment_xpath, String likeNewsBtn_xpath, String comInputTextArea_xpath, String commentEditBox_xpath, String commitCommentBtn_xpath, String commitReplyBtn_xpath, String newsDetailText_xpath, String deleteReply_xpath, String likeComment_xpath, String androidBtn_classname) {
        this.homePage_xpath = homePage_xpath;
        this.newsViewGroup_id = newsViewGroup_id;
        this.newsDetailBanner_xpath = newsDetailBanner_xpath;
        this.newsBannerDetail_xpath = newsBannerDetail_xpath;
        this.newsDetailImg_xpath = newsDetailImg_xpath;
        this.newsDetailVideo_xpath = newsDetailVideo_xpath;
        HotComment_xpath = hotComment_xpath;
        AllComent_xpath = allComent_xpath;
        CommentReply_xpath = commentReply_xpath;
        ReplyEditBox_xpath = replyEditBox_xpath;
        WriteComment_xpath = writeComment_xpath;
        LikeNewsBtn_xpath = likeNewsBtn_xpath;
        ComInputTextArea_xpath = comInputTextArea_xpath;
        CommentEditBox_xpath = commentEditBox_xpath;
        CommitCommentBtn_xpath = commitCommentBtn_xpath;
        CommitReplyBtn_xpath = commitReplyBtn_xpath;
        this.newsDetailText_xpath = newsDetailText_xpath;
        DeleteReply_xpath = deleteReply_xpath;
        this.likeComment_xpath = likeComment_xpath;
        this.androidBtn_classname = androidBtn_classname;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
