package com.warren.fleet.mapper;
import com.warren.fleet.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    public int insert(User user);

    public void update(User user);

    public void delete(int id);



    public User selectByUid(int uid);

    public List<User> selectAll();

    public List<User> selectBlogs(int uid);
}
