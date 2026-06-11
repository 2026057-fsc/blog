package com.example.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    
    private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Blog> findAll(){
        return jdbcClient.sql("SELECT * FROM blogs")
        .query(Blog.class)
        .list();
    }

    public void save(Blog blog){
        jdbcClient.sql("INSERT INTO blogs(title, notes, author) VALUES (:title, :notes, :author)")
                .param("title", blog.getTitle())
                .param("notes", blog.getNotes())
                .param("author", blog.getAuthor())
                .update();
    }

    public Optional<Blog> findById(Long id){
        return jdbcClient.sql("SELECT id, title, notes, author FROM blogs WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .optional();
    }
}
