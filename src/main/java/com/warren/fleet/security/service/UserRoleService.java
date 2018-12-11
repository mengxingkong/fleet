package com.warren.fleet.security.service;

import com.warren.fleet.security.bean.Role;
import com.warren.fleet.security.bean.User;
import com.warren.fleet.security.mapper.RoleMapper;
import com.warren.fleet.security.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRoleService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;

    @Transactional
    public User inserUserRole(User user, String rolename){
        userDao.insertUser(user);
        user = userDao.findUserOnlyByName(user.getUname());
        Role role = roleService.selectRoleByName(rolename);
        userDao.insertUserRole(user.getUid(),role.getRid());
        return user;
    }
}
