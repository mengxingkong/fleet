package com.warren.fleet.security.service;

import com.warren.fleet.security.bean.Role;
import com.warren.fleet.security.bean.User;
import com.warren.fleet.security.bean.UserInfo;
import com.warren.fleet.security.jwt.JwtUserFactory;
import com.warren.fleet.security.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUserName(username);
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