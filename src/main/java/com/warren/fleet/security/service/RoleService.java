package com.warren.fleet.security.service;

import com.warren.fleet.security.bean.Role;
import com.warren.fleet.security.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Role selectRoleByName(String rolename){

       return roleMapper.selectRoleByName(rolename);

    }

}
