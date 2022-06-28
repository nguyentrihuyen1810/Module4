package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.impl.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String titleSearch, String categoryIdSearch) {
        return blogRepository.findByTitleAndCategory("%"+titleSearch+"%", "%"+categoryIdSearch+"%", pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(Math.toIntExact(id));
    }
}
