package com.example.liapi.entity;

public class User {

    /**
     * phone : 13888888888
     * name : peakchao
     * nikeName : 飞翔的水牛
     * autograph : 没有个性，没有签名
     * email : 123456@qq.com
     * remarks : 这是一个备注，啦啦啦啦~
     * headerImg : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_86d58ae1.png
     * vipGrade : 6
     */
    private String phone;
    private String name;
    private String nikeName;
    private String autograph;
    private String email;
    private String remarks;
    private String headerImg;
    private String vipGrade;

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
