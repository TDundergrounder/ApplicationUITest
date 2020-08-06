package com.aiways.models.androidModels.news;

import com.google.gson.Gson;

import java.security.SecureRandom;

public class NewsDataModel {

    private String CommentContent;

    private String  ComReplyContent;

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    public String getComReplyContent() {
        return ComReplyContent;
    }

    public void setComReplyContent(String comReplyContent) {
        ComReplyContent = comReplyContent;
    }

    public NewsDataModel(String commentContent, String comReplyContent) {
        this.CommentContent = commentContent;
        this.ComReplyContent = comReplyContent;
    }

    @Override
    public String toString() {
        return new Gson().toString();
    }
}

