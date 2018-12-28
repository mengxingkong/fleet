package com.warren.fleet.security.controller;

import com.alibaba.fastjson.JSON;
import com.warren.fleet.common.domain.MsgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MsgResult msg;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/alluser")
    public String getAllUser(){

        return JSON.toJSONString(msg);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit")
    public String editUserInfo(){
        return JSON.toJSONString(msg);
    }
}
