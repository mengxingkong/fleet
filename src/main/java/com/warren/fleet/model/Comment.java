package com.warren.fleet.model;

import java.sql.Date;

public class Comment {

    private int cid;
    private int uid;
    private int bid;
    private String content;
    private Date c_time;

    public Comment() {
    }

    public Comment(int cid, int uid, int bid, String content, Date c_time) {
        this.cid = cid;
        this.uid = uid;
        this.bid = bid;
        this.content = content;
        this.c_time = c_time;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getC_time() {
        return c_time;
    }

    public void setC_time(Date c_time) {
        this.c_time = c_time;
    }
}