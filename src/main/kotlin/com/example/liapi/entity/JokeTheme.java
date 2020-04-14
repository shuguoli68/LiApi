package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 笑话的分类
 */
@ApiModel(value = "JokeTheme",description = "笑话的分类")
public class JokeTheme {
    @ApiModelProperty(value = "表自增的id")
    private int id;
    @ApiModelProperty(value = "分类的ID")
    private String themeId = "";
    @ApiModelProperty(value = "分类的名称")
    private String title = "";
    @ApiModelProperty(value = "分类的简称")
    private String brief = "";
    @ApiModelProperty(value = "图片")
    private String picUrl = "";
    @ApiModelProperty(value = "该分类下的数量")
    private int count = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
