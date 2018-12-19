//package com.warren.fleet.security.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.warren.fleet.blog.domain.User;
//import com.warren.fleet.blog.service.UserService;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@RestController
//@RequestMapping("/user")
//@MapperScan("com.warren.fleet.mapper")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/index")
//    public ModelAndView index(){
//        return new ModelAndView("pages/index");
//    }
//
//    @RequestMapping("/showUser")
//    public String selectUser(@RequestParam(value = "uid", defaultValue = "1") int uid){
//        User user = userService.selectUserByUid(uid);
//        if(null!=user){
//            return JSON.toJSONString(user);
//        }
//        else{
//            return JSON.toJSONString("result:null");
//        }
//    }
//
//
//    @RequestMapping("/allUser")
//    public String selectAllUser(){
//        return JSON.toJSONString( userService.selectAllUser() );
//    }
//
//    @PostMapping(value = "/addUser")
//    public String addUser(User user){
//        userService.addUser(user);
//        return "done";
//    }
//
//    @PostMapping("/updateUser")
//    public String updateUser(User user){
//        userService.update(user);
//        return "done";
//    }
//
//    @GetMapping("/showBlogs")
//    public String showBlogs(@RequestParam(value = "uid", required = false) int uid ){
//        return JSON.toJSONString(userService.selectUserBlogs(uid));
//    }
//}
