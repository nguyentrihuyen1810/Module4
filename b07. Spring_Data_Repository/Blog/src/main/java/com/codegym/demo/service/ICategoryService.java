package com.codegym.demo.service;

import com.codegym.demo.model.Category;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
