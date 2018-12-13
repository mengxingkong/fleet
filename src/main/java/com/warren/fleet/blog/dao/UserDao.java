package com.warren.fleet.blog.dao;
import com.warren.fleet.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public User selectUserByName(String uname);

    public List<User> selectAll();

    public void delete(String uname);

    public void addUser(String uname,String npasswd);


    //保留之前使用对象进行插入更新的操作
    public int insert(User user);
    public void update(User user);
}
