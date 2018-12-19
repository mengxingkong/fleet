package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysRole;
import com.warren.fleet.security.dao.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {

    @Autowired
    private SysRoleDao roleMapper;

    public SysRole selectRoleByName(String rolename){

       return roleMapper.selectRoleByName(rolename);

    }

}
