package com.warren.fleet.security.service;

import com.warren.fleet.security.bean.UserInfo;
import com.warren.fleet.security.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；

        UserDetails userDetails = userDetailService.loadUserByUsername(userName);

        if (userDetails == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        if (!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);

    }
//        // 这里构建来判断用户是否存在和密码是否正确
//        User user = (UserInfo) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
//        if (userInfo == null) {
//            throw new BadCredentialsException("用户名不存在");
//        }
//
//
//        if (!userInfo.getPassword().equals(password)) {
//            throw new BadCredentialsException("密码不正确");
//        }
//        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
//        // 构建返回的用户登录成功的token
//        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
