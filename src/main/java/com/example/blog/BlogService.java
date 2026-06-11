package com.example.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    public void add(BlogForm blogForm){
        if (blogForm.getTitle() == null) {
            throw new IllegalArgumentException("タイトルが空です。");
        }
        if (blogForm.getNotes() == null) {
            throw new IllegalArgumentException("本文を記載してください。");
        }

        blogRepository.save(new Blog(null, blogForm.getTitle(), blogForm.getNotes(), blogForm.getAuthor()));
    }

    public Optional<Blog> findById(Long id){
        return blogRepository.findById(id);
    }
}
