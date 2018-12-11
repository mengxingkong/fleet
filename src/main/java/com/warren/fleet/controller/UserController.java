package com.warren.fleet.controller;

import com.alibaba.fastjson.JSON;
import com.warren.fleet.model.User;
import com.warren.fleet.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
@MapperScan("com.warren.fleet.mapper")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("pages/index");
    }

    @RequestMapping("/showUser")
    public String selectUser(@RequestParam(value = "uid", defaultValue = "1") int uid){
        User user = userService.selectUserByUid(uid);
        if(null!=user){
            return JSON.toJSONString(user);
        }
        else{
            return JSON.toJSONString("result:null");
        }
    }


    @RequestMapping("/allUser")
    public String selectAllUser(){
        return JSON.toJSONString( userService.selectAllUser() );
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "done";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user){
        userService.update(user);
        return "done";
    }

    @GetMapping("/showBlogs")
    public String showBlogs(@RequestParam(value = "uid", required = false) int uid ){
        return JSON.toJSONString(userService.selectUserBlogs(uid));
    }




















    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }

    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }




}
