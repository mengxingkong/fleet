package com.warren.fleet.security.mapper;

import com.warren.fleet.security.bean.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    public Role selectRoleByName(String rolename);

}
