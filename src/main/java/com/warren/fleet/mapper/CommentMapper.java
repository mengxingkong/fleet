package com.warren.fleet.mapper;

import com.warren.fleet.model.Blog;
import com.warren.fleet.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    public List<Comment> seletCommentByBlog(Blog blog);
    public void insert(Comment comment);
}
