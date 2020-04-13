package com.example.liapi.entity;

/**
 * 网易新闻
 * {
 *             "path": "http://travel.163.com/photoview/17KK0006/2144698.html",
 *             "image": "http://cms-bucket.ws.126.net/2019/10/21/15a5befdd98e4cdfb5cb2aa2b95ac1ea.jpeg?imageView&thumbnail=140y88&quality=85",
 *             "title": "去北极的人平常都吃些什么?",
 *             "passtime": "2019-10-22 10:00:45"
 *         }
 */

public class WYNews {

    /**
     * path : http://travel.163.com/photoview/17KK0006/2144698.html
     * image : http://cms-bucket.ws.126.net/2019/10/21/15a5befdd98e4cdfb5cb2aa2b95ac1ea.jpeg?imageView&thumbnail=140y88&quality=85
     * title : 去北极的人平常都吃些什么?
     * passtime : 2019-10-22 10:00:45
     */

    private int id = 0;
    private String path;
    private String image;
    private String title;
    private String passtime;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
