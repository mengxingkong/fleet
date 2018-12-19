package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysRole;
import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRoleService {

    @Autowired
    private SysUserDao userDao;
    @Autowired
    private RoleService roleService;

    @Transactional
    public SysUser inserUserRole(SysUser user, String rolename){
        userDao.insertUser(user);
        user = userDao.findUserOnlyByName(user.getUname());
        SysRole role = roleService.selectRoleByName(rolename);
        userDao.insertUserRole(user.getUid(),role.getRid());
        return user;
    }
}
