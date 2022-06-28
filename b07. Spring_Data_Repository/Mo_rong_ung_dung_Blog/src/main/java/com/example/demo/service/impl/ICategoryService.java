package com.example.demo.service.impl;

import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
