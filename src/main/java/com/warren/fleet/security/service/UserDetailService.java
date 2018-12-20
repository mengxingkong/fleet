package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysRole;
import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailService implements UserDetailsService {

    @Autowired
    private SysUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        }
        //这里可以增加用户状态的判断

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户权限
        for(SysRole role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRname()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUname(),
                user.getUpasswd(), authorities);
    }
}