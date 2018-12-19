package com.warren.fleet.blog.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = -953600035074775419L;

    private Integer uid;
    private String uname;
    private String upasswd;

    private List<Blog> blogs;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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

}
