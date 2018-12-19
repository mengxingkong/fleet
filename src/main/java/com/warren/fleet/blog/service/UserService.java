package com.warren.fleet.blog.service;

import com.warren.fleet.blog.dao.UserDao;
import com.warren.fleet.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Cacheable(value = "user", key = "'user_'+#uname")
    public User selectUserByUname(String uname){
        System.out.println("没有从缓存读取数据");
        return userDao.selectUserByName(uname);
    }

    @Cacheable(value = "user",key = "#root.methodName")
    public List<User> selectAllUser(){
        return userDao.selectAll();
    }

    public void addUser(String uname,String upasswd){
        userDao.addUser(uname,upasswd);
    }
}
