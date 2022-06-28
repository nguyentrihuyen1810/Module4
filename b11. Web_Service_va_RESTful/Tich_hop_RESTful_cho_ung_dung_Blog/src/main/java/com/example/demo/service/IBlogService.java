package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findByAll(Pageable pageable);
    Page<Blog> search(String titleSearch, String categoryIdSearch, Pageable pageable);
    Blog findById(Integer id);
    void add(Blog blog);
    void edit(Blog blog);
    void delete(Integer id);

}
