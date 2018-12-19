package com.warren.fleet.security.service;

import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtTokenUtil;
import com.warren.fleet.security.jwt.JwtUser;
import com.warren.fleet.security.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    private AuthenticationManager authenticationManager;
    private MyUserDetailService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private SysUserDao userRepository;
    private UserRoleService userRoleService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           MyUserDetailService userDetailsService,
                           JwtTokenUtil jwtTokenUtil,
                           SysUserDao userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }

    public SysUser register(SysUser user){
        final String username = user.getUname();
        if(userRepository.findUserOnlyByName(username)!=null){
            return null;
        }
        return userRoleService.inserUserRole(user,"ROLE_USER");
    }

    public String login(String username,String password){
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateAccessToken(userDetails);
        return token;
    }

    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        System.out.println(user.getUsername()+"****************");
        int a = 1+2;
        if (user!=null){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

}
