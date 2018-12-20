package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysUser;

public interface AuthService {
    String regisiter(SysUser user);
    String login(String uname,String upasswd);
    String refresh(String oldtoken);
}
