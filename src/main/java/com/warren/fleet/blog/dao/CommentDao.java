package com.warren.fleet.blog.dao;

import com.warren.fleet.blog.domain.Blog;
import com.warren.fleet.blog.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    public List<Comment> seletCommentByBlog(Blog blog);
    public void insert(Comment comment);
}
