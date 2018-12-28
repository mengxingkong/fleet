package com.warren.fleet.security.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleDao {
    public void addUserRoleByName(String uname,String rname );
    public void deleteUserRoleByUserName(String uname);
}
