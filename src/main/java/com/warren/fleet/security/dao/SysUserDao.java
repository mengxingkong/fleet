package com.warren.fleet.security.dao;


import com.warren.fleet.security.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    public SysUser findByUserName(String username);
    public SysUser findUserOnlyByName(String username);
    public void insertUser(SysUser user);
    public void insertUserRole(int uid, int rid);
}
