package com.warren.fleet.security.dao;

import com.warren.fleet.security.domain.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleDao {

    public SysRole selectRoleByName(String rolename);

    public List<SysRole> getRoles();

    public void addUserRoleByName(String uname,String rolename);

}
