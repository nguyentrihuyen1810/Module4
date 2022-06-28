package com.example.demo.dto;

import com.example.demo.model.Category;

import javax.validation.constraints.NotEmpty;

public class BlogDTO {
    private Long id;
    @NotEmpty(message = "Ten khong duoc de trong")
    private String author;
    @NotEmpty(message = "Tieu de khong duoc de trong")
    private String title;
    private String content;
    private Category category;

    public BlogDTO() {
    }

    public BlogDTO(Long id, String author, String title, String content, Category category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
