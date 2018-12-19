package com.warren.fleet.blog.domain;

public class Comment {

    private int cid;
    private String user;
    private String bioid;
    private String content;
    private String committime;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBioid() {
        return bioid;
    }

    public void setBioid(String bioid) {
        this.bioid = bioid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommittime() {
        return committime;
    }

    public void setCommittime(String committime) {
        this.committime = committime;
    }
}