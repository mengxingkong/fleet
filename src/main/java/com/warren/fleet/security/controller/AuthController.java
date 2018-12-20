package com.warren.fleet.security.controller;

import com.warren.fleet.security.domain.SysUser;
import com.warren.fleet.security.jwt.JwtAuthenticationResponse;
import com.warren.fleet.security.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthServiceImpl authService;

    @RequestMapping("/login/before")
    public String loginPage(){
        return "please login";
    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SysUser user)
            throws AuthenticationException {
        final String token = authService.login(user.getUname(),user.getUpasswd());

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


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

    @PreAuthorize("hasRole(''USER)")
    @RequestMapping("/register")
    public String register(@RequestBody SysUser addedUser)
            throws AuthenticationException{
        return authService.regisiter(addedUser);
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
