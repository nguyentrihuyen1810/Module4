package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String titleSearch, String categoryIdSearch);
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
}
