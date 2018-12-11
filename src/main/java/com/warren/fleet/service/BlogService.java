package com.warren.fleet.service;

import com.warren.fleet.mapper.BlogMapper;
import com.warren.fleet.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public void addBlog(Blog blog){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        blog.setF_time(sdf.format(new Date()));
        blog.setL_time(sdf.format(new Date()));
        blogMapper.insert(blog);
    }

    public void updateBlog(Blog blog){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        blog.setL_time(sdf.format(new Date()));
        blogMapper.update(blog);
    }

    public Blog selectBlogByBid(int bid){
        return blogMapper.selectBlogByBid(bid);
    }
}
