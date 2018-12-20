package com.warren.fleet.security.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangyibo on 17/1/17.
 */

public class SysUser implements Serializable {

    private static final long serialVersionUID = -5795324543331170824L;
    private Integer uid;
    private String uname;
    private String upasswd;
    private String lastmodified;
    private List<SysRole> roles;

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

    public String getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(String lastmodified) {
        this.lastmodified = lastmodified;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
