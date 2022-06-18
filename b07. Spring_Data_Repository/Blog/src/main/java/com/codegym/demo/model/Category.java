package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Category {
    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category")


    private List<Blog> blogs;

    public Category() {
    }

    public Category(Integer id, String name, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
