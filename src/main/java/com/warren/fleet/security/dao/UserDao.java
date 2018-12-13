package com.warren.fleet.security.dao;


import com.warren.fleet.security.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User findByUserName(String username);
    public User findUserOnlyByName(String username);
    public void insertUser(User user);
    public void insertUserRole(int uid, int rid);
}
