package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<Blog> blogs;

    public Category() {
    }

    public Category(Integer id, String name, Collection<Blog> blogs) {
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

    public void setBlogs(Collection<Blog> blogs) {
        this.blogs = blogs;
    }
}
