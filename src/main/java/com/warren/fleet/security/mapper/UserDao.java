package com.warren.fleet.security.mapper;


import com.warren.fleet.security.bean.Role;
import com.warren.fleet.security.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByUserName(String username);
    public User findUserOnlyByName(String username);
    public void insertUser(User user);
    public void insertUserRole(int uid, int rid);
}
