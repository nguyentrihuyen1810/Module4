package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute
    public List<Category> getBlogList() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<Blog> getList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogs = this.blogService.findByAll((org.springframework.data.domain.Pageable) pageable);
        return new ResponseEntity(blogs.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> find(@PathVariable int id) {
        Optional<Blog> blog = Optional.ofNullable(blogService.findById(id));
        if(!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id) {
        Optional<Blog> blog = Optional.ofNullable(blogService.findById(id));
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}
