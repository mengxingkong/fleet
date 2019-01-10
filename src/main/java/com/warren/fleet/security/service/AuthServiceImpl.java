package com.warren.fleet.security.service;

import com.alibaba.fastjson.JSON;
import com.warren.fleet.common.domain.MsgResult;
import com.warren.fleet.common.util.CurrentTimeUtil;
import com.warren.fleet.security.dao.SysRoleDao;
import com.warren.fleet.security.dao.SysUserRoleDao;
import com.warren.fleet.security.domain.ResetPwd;
import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtTokenUtil;
import com.warren.fleet.security.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomDetailService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysUserDao userDao;

    @Autowired
    private SysRoleDao roleDao;

    @Autowired
    private SysUserRoleDao userRoleDao;

    @Autowired
    MsgResult msg;

    @Override
    public String regisiter(SysUser user) {
        if( userDao.findByUserName(user.getUname())==null ){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setUpasswd( encoder.encode(user.getUpasswd()) );
            userDao.addUser(user.getUname(),user.getUpasswd(), CurrentTimeUtil.format(new Date()));
            userRoleDao.addUserRoleByName(user.getUname(), "ROLE_USER");
            msg.setStatus("ok");
            msg.setContent("register success,please login");
            return JSON.toJSONString( msg );
        }
        else{
            msg.setStatus("already exist");
            msg.setContent("this username has already register");
            return JSON.toJSONString( msg );
        }

    }

    @Override
    public String login(String uname, String upasswd) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(uname,upasswd);
        try{
            final Authentication authentication  = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
            final String token = jwtTokenUtil.generateToken(userDetails);
            return token;
        }catch (Exception e){
            e.printStackTrace();
            return "{status:fail to generate token }";
        }
    }

    @Override
    public String refresh(String oldtoken) {
        String uname = jwtTokenUtil.generateUserNameFromToken(oldtoken);
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
            Date lastmodified = CurrentTimeUtil.prase(userDao.findByUserName(uname).getLastmodified());
            if(userDetails!=null && jwtTokenUtil.canTokenBeRefresh(oldtoken,lastmodified)){
                return jwtTokenUtil.refreshToken(userDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "failed to refresh token";
    }

    @Override
    public String resetPasswd(ResetPwd resetPwd){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDao.resetPasswd(resetPwd.getUname(), encoder.encode( resetPwd.getNewpasswd() ),CurrentTimeUtil.format(new Date()));
        msg.setStatus("ok");
        msg.setContent("reset passwd success");
        return JSON.toJSONString(msg);
    }
}
