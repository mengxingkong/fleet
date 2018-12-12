package com.warren.fleet.security.controller;

import com.warren.fleet.security.bean.Role;
import com.warren.fleet.security.bean.User;
import com.warren.fleet.security.mapper.UserDao;
import com.warren.fleet.security.requestBody.JwtAuthenticationRequest;
import com.warren.fleet.security.response.JwtAuthenticationResponse;
import com.warren.fleet.security.service.AuthService;
import com.warren.fleet.security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public String loginPage(){
        return "please login";
    }


    @RequestMapping("/login/form")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
            throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getUsername(),authenticationRequest.getPassword());

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

    @RequestMapping("/register")
    public User register(@RequestBody User addedUser)
            throws AuthenticationException{
        return authService.register(addedUser);
    }


    @RequestMapping("/success")
    public Object success(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping("/error")
    public String error(){
        return "login_error";
    }
}
