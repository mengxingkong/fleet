package com.warren.fleet.security.dao;

public interface SysUserRoleDao {
    public void addUserRoleByName(String uname,String rname );

    public void deleteUserRoleByUserName(String uname);
}
