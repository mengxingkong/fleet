package com.warren.fleet.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private int uid;
    private String uname;
    private String upasswd;

    private List<Blog> blogs;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpasswd() {
        return upasswd;
    }

    public void setUpasswd(String upasswd) {
        this.upasswd = upasswd;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString(){
        return "uid:" + uid +"\n"
                +"uname:" + uname +"\n"
                +"upasswd:" + upasswd;
    }
}
