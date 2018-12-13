package com.warren.fleet.blog.service;

import com.warren.fleet.blog.dao.BlogDao;
import com.warren.fleet.blog.model.Blog;
import com.warren.fleet.common.util.CurrentTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BlogService {

    @Autowired
    private BlogDao blogDao;

    public void addBlog(Blog blog){
        blog.setCommittime(CurrentTimeUtil.format( new Date() ));
        blog.setUpdatetime( CurrentTimeUtil.format( new Date() ) );
        blogDao.insert(blog);
    }

    public void updateBlog(Blog blog){
        blog.setUpdatetime( CurrentTimeUtil.format( new Date() ) );
        blogDao.update(blog);
    }

    public Blog selectBlogByBid(String bioid){
        return blogDao.selectBlogByBloid( bioid );
    }
}
