package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "instructor_category",
                joinColumns = @JoinColumn(name = "instructor_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))

    private List<Category> categoryList;

    public Instructor() {
    }

    public Instructor(Integer id, String name, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.categoryList = categoryList;
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
