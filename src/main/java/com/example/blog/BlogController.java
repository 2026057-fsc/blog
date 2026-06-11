package com.example.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String Blogs(Model model) {
        List<Blog> blogsList = blogService.findAll();
        model.addAttribute("blogsList", blogsList);
        return "blogs";
    }

    @GetMapping("/blogs/new")
    public String blognew(Model model) {
        model.addAttribute("blogForm", new BlogForm());
        return "blogs/new";
    }

    @PostMapping("/blogs")
    public String createBlog(@ModelAttribute BlogForm blogForm) {
        blogService.add(blogForm);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blogdetail", blogOpt.get());
        return "blogs/blogdetail";
    }

}
