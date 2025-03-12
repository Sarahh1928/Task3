package com.example.Task_3.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    public Post() {

    }
public Post(String id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
}
    public Post(String id, String title, String content, User author, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }
    public Post( String title, String content, User author, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }


    @DBRef
    private User author;

    private List<Comment> comments;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
