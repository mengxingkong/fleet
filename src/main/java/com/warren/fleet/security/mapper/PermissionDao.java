package com.warren.fleet.security.mapper;

import com.warren.fleet.security.bean.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
