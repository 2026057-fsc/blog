package com.example.blog;

public class Blog {
    private final Long id;
    private final String title;
    private final String notes;
    private final String author;


    public Blog (Long id, String title, String notes, String author){
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.author = author;
        
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

    public String getAuthor() {
        return author;
    }
    
}
