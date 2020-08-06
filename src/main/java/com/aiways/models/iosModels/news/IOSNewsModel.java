package com.aiways.models.iosModels.news;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSNewsModel implements Serializable {

    private String CommentContent;

    private String ComReplyContent;

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

    public IOSNewsModel(String commentContent, String comReplyContent) {
        CommentContent = commentContent;
        ComReplyContent = comReplyContent;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
