package com.warren.fleet.model;

public class Blog {

    private int bid;
    private int author;
    private String title;
    private String content;
    private String f_time; // first submit time
    private String l_time; // last update time
    private User oneAuthor;


    public User getOneAuthor() {
        return oneAuthor;
    }

    public void setOneAuthor(User oneAuthor) {
        this.oneAuthor = oneAuthor;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getF_time() {
        return f_time;
    }

    public void setF_time(String f_time) {
        this.f_time = f_time;
    }

    public String getL_time() {
        return l_time;
    }

    public void setL_time(String l_time) {
        this.l_time = l_time;
    }
}
