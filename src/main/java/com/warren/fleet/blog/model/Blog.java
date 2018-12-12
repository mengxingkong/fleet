package com.warren.fleet.blog.model;

public class Blog {

    private int id;
    private String bloid;
    private String author;
    private String title;
    private String content;
    private String committime; // first submit time
    private String updatetime; // last update time

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloid() {
        return bloid;
    }

    public void setBloid(String bloid) {
        this.bloid = bloid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public String getCommittime() {
        return committime;
    }

    public void setCommittime(String committime) {
        this.committime = committime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
