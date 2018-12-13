package com.warren.fleet.blog.dao;

import com.warren.fleet.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {
    public Blog selectBlogByBloid(String bioid);

    public List<Blog> selectAllBlogs();

    public List<Blog> selectBlogsByTitile(String title);

    public List<Blog> selectBlogsByAuthor(String author);

    public void addBlog(String bioid,String author,String content,String title,String committime,String updatetime);

    public void updateBlog(String bioid,String author,String content,String title,String committime,String updatetime);

    public void delete(int bioid);





    //保留之前 使用对象作为参数的插入更新操作
    public void insert(Blog blog);
    public void update(Blog blog);
}
