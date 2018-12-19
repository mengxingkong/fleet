package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtUserFactory;
import com.warren.fleet.security.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = userDao.findByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        }
        return JwtUserFactory.create(user);

    }
}

//        if(s.equals("admin")){
//            UserInfo userInfo = new UserInfo("admin", "123456", "ROLE_ADMIN", true,true,true, true);
//            return userInfo;
//        }