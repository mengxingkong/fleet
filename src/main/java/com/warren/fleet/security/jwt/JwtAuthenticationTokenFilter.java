package com.warren.fleet.security.jwt;

import com.warren.fleet.common.util.CurrentTimeUtil;
import com.warren.fleet.security.dao.SysUserDao;
import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtTokenUtil;
import com.warren.fleet.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysUserDao userDao;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        //取token
        String token = request.getHeader(this.tokenHeader);

        //处理token
        if (token != null) {
            String username = jwtTokenUtil.generateUserNameFromToken(token);
            String role = jwtTokenUtil.getTokenRoleFromToken(token);
            logger.info("checking authentication " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
                //获取最近更新时间，判断token是否有效
                try {
                    SysUser user = userDao.findByUserName(username);
                    Date lastmodified = CurrentTimeUtil.prase(user.getLastmodified());
                    if(jwtTokenUtil.validateToken(token,lastmodified)){
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }catch (Exception e){
                    logger.info("时间格式错误");
                }
            }
        }
        chain.doFilter(request, response);
    }
}
