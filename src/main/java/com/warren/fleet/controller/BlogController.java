package com.warren.fleet.controller;

import com.alibaba.fastjson.JSON;
import com.warren.fleet.model.Blog;
import com.warren.fleet.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/allBlogs")
    public String index(){
        return "all blog";
    }


    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping("/addBlog")
    public String addBlog(Blog blog){
        blogService.addBlog(blog);
        return "done";
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping("/updateBlog")
    public String updateBlog(Blog blog){
        blogService.updateBlog(blog);
        return "done";
    }

    @PreAuthorize("hasRole('ROLE_DB')")
    @GetMapping("/showBlog")
    public String showBlog(@RequestParam(value = "bid", defaultValue = "-1") int bid){
        return JSON.toJSONString(blogService.selectBlogByBid(bid));
    }
}
