package com.example.Task_3.models;

import org.springframework.data.mongodb.core.mapping.Document;

public class Comment {
    private String text;
    private String date;

    public Comment() {
    }
    public Comment(String text) {
        this.text = text;
    }

    public Comment(String date, String text) {
        this.date = date;
        this.text = text;
    }

    // Getters and Setters
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
