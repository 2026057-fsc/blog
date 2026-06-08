package com.example.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }
    
    @GetMapping("/blogs")
    public String Blogs (Model model){
        List<Blog> blogsList = blogService.findAll();
        model.addAttribute("blogsList", blogsList);
        return "blogs";
    }

    
}
