package com.codegym.demo.dto;

import com.codegym.demo.model.Category;

import javax.validation.constraints.NotEmpty;

public class BlogDTO {
    private Integer id;
    @NotEmpty(message = "Tieu de khong duoc de trong")
    private String title;
    private String content;
    private Category category;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
