package com.warren.fleet.service;

import com.warren.fleet.mapper.UserMapper;
import com.warren.fleet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "user", key = "'user_'+#uid")
    public User selectUserByUid(int uid){
        System.out.println("没有从缓存读取数据");
        return userMapper.selectByUid(uid);
    }

    @Cacheable(value = "user",key = "#root.methodName")
    public List<User> selectAllUser(){
        return userMapper.selectAll();
    }
    public void addUser(User user){
        int uid = userMapper.insert(user);
        System.out.println(uid); //??????
    }
    public void update(User user){
        userMapper.update(user);
    }

    public List<User> selectUserBlogs(int uid){
        return userMapper.selectBlogs(uid);
    }
}
