package com.aiways.models.iosModels.news;

import com.google.gson.Gson;

import java.io.Serializable;

public class IOSNewsLocateModel implements Serializable {

    private String HomeBtn_IosNsPredicate;

    private String XCUIElementTypeCells_xpath;

    private String back_AccessibilityId;

    private String imgElementsLis1t_IosNsPredicate;

    private String imgElementsList2_IosNsPredicate;

    public String getHomeBtn_IosNsPredicate() {
        return HomeBtn_IosNsPredicate;
    }

    public void setHomeBtn_IosNsPredicate(String homeBtn_IosNsPredicate) {
        HomeBtn_IosNsPredicate = homeBtn_IosNsPredicate;
    }

    public String getXCUIElementTypeCells_xpath() {
        return XCUIElementTypeCells_xpath;
    }

    public void setXCUIElementTypeCells_xpath(String XCUIElementTypeCells_xpath) {
        this.XCUIElementTypeCells_xpath = XCUIElementTypeCells_xpath;
    }

    public String getBack_AccessibilityId() {
        return back_AccessibilityId;
    }

    public void setBack_AccessibilityId(String back_AccessibilityId) {
        this.back_AccessibilityId = back_AccessibilityId;
    }

    public String getImgElementsLis1t_IosNsPredicate() {
        return imgElementsLis1t_IosNsPredicate;
    }

    public void setImgElementsLis1t_IosNsPredicate(String imgElementsLis1t_IosNsPredicate) {
        this.imgElementsLis1t_IosNsPredicate = imgElementsLis1t_IosNsPredicate;
    }

    public String getImgElementsList2_IosNsPredicate() {
        return imgElementsList2_IosNsPredicate;
    }

    public void setImgElementsList2_IosNsPredicate(String imgElementsList2_IosNsPredicate) {
        this.imgElementsList2_IosNsPredicate = imgElementsList2_IosNsPredicate;
    }

    public IOSNewsLocateModel(String homeBtn_IosNsPredicate, String XCUIElementTypeCells_xpath, String back_AccessibilityId, String imgElementsLis1t_IosNsPredicate, String imgElementsList2_IosNsPredicate) {
        HomeBtn_IosNsPredicate = homeBtn_IosNsPredicate;
        this.XCUIElementTypeCells_xpath = XCUIElementTypeCells_xpath;
        this.back_AccessibilityId = back_AccessibilityId;
        this.imgElementsLis1t_IosNsPredicate = imgElementsLis1t_IosNsPredicate;
        this.imgElementsList2_IosNsPredicate = imgElementsList2_IosNsPredicate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
