package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String titleSearch, String categoryIdSearch);
    Blog findById(Integer id);
    void save(Blog blog);
    void delete (Integer id);
}
