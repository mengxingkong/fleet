package com.warren.fleet.security.dao;

import com.warren.fleet.security.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    public Role selectRoleByName(String rolename);

}
