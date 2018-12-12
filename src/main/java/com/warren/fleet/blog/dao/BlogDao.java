package com.warren.fleet.blog.dao;

import com.warren.fleet.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {
    public Blog selectBlogByBid(int bid);

    public List<Blog> selectAllBlogs();

    public List<Blog> selectBlogsByTitile(String title);

    public List<Blog> selectBlogsByAuthor(String author);

    public void insert(Blog blog);

    public void update(Blog blog);

    public void delete(int bid);
}
