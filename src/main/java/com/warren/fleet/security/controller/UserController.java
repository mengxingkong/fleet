package com.warren.fleet.security.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@MapperScan("com.warren.fleet.mapper")
public class UserController {

}
