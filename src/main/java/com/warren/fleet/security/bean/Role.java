package com.warren.fleet.security.bean;

/**
 * Created by yangyibo on 17/1/17.
 */

public class Role {

    private Integer rid;
    private String rname;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return this.rname;
    }
}
