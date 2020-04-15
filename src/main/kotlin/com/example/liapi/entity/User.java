package com.example.liapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User",description = "用户")
public class User {


    @ApiModelProperty(value = "表自增的id")
    private int id = 0;
    @ApiModelProperty(value = "用户Id")
    private String userId;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "昵称")
    private String nikeName;
    @ApiModelProperty(value = "个性签名")
    private String autograph;
    @ApiModelProperty(value = "email邮箱")
    private String email;
    @ApiModelProperty(value = "备注信息")
    private String remarks;
    @ApiModelProperty(value = "头像")
    private String headerImg;
    @ApiModelProperty(value = "等级")
    private String vipGrade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public void setVipGrade(String vipGrade) {
        this.vipGrade = vipGrade;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public String getAutograph() {
        return autograph;
    }

    public String getEmail() {
        return email;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public String getVipGrade() {
        return vipGrade;
    }
}
