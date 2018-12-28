package com.warren.fleet.security.controller;

import com.warren.fleet.security.domain.ResetPwd;
import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtAuthenticationResponse;
import com.warren.fleet.security.service.AuthServiceImpl;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/login/before")
    public String loginPage(){
        return "please login";
    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SysUser user)
            throws AuthenticationException {

        System.out.println("test");
        final String token = authService.login(user.getUname(),user.getUpasswd());

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        System.out.println(refreshedToken);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping("/register")
    public String register(@RequestBody SysUser addedUser)
            throws AuthenticationException{
        return authService.regisiter(addedUser);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/louout")
    public String logout(){
        return "ok";
    }


    @PreAuthorize("hasRole('USER') and #resetPwd.uname==authentication.name")
    @PostMapping("/resetpwd")
    public String resetPasswd(@RequestBody ResetPwd resetPwd){
        UsernamePasswordAuthenticationToken uptoken = new UsernamePasswordAuthenticationToken(resetPwd.getUname(),resetPwd.getOldpasswd());
        final Authentication authorization = authenticationManager.authenticate(uptoken);
        SecurityContextHolder.getContext().setAuthentication(authorization);
        return authService.resetPasswd(resetPwd);
    }

//    @RequestMapping("/success")
//    public Object success(){
//        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
//
//    @RequestMapping("/error")
//    public String error(){
//        return "login_error";
//    }
}
