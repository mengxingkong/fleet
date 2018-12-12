package com.warren.fleet.blog.dao;
import com.warren.fleet.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public int insert(User user);

    public void update(User user);

    public void delete(int id);

    public User selectByUid(int uid);

    public List<User> selectAll();

    public List<User> selectBlogs(int uid);
}
