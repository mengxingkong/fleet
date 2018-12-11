package com.warren.fleet.security.bean;

/**
 * Created by yangyibo on 17/1/20.
 */
public class Permission {

    private int pid;
    //权限名称
    private String pname;

    //权限描述
    private String descritpion;

    //授权链接
    private String url;

    //父节点id
    private int p_pid;

    //请求方法
    private String method;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getP_pid() {
        return p_pid;
    }

    public void setP_pid(int p_pid) {
        this.p_pid = p_pid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
