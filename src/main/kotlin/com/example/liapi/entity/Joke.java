package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 笑话
 */
@ApiModel(value = "Joke",description = "笑话")
public class Joke {
    @ApiModelProperty(value = "表自增的id")
    private int id = 0;
    @ApiModelProperty(value = "笑话的ID")
    private String jokeId = "";
    @ApiModelProperty(value = "笑话的内容")
    private String content = "";
    @ApiModelProperty(value = "笑话的分类")
    private String themeId = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }
}
