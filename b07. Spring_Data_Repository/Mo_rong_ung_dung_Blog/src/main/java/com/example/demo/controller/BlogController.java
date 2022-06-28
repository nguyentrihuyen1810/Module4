package com.example.demo.controller;

import com.example.demo.dto.BlogDTO;
import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.impl.IBlogService;
import com.example.demo.service.impl.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> getList() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public String getList1(Model model, @RequestParam(defaultValue = "0") int page,
                           Optional<String> titleSearch, Optional<String> categoryIdSearch) {
        String titleSearchValue = "";
        String categoryIdSearchValue = "";
        if(titleSearch.isPresent()) {
            titleSearchValue = titleSearch.get();
        }
        if(categoryIdSearch.isPresent()) {
            categoryIdSearchValue = categoryIdSearch.get();
        }
        model.addAttribute("titleSearch", titleSearchValue);
        model.addAttribute("categoryIdSearch", categoryIdSearch);
        Page<Blog> blogs = blogService.findAll(PageRequest.of(page, 4), titleSearchValue, categoryIdSearchValue);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("create")
    public String createBlog(@ModelAttribute @Validated BlogDTO blogDTO, BindingResult bindingResult, Model model) {
        Blog blog = new Blog();
        if(bindingResult.hasErrors()) {
            model.addAttribute("mess", "Them moi khong thanh cong");
            return "blog/create";
        } else {
            BeanUtils.copyProperties(blogDTO, blog);
            blogService.save(blog);
            model.addAttribute("blogDTO", blogDTO);
            model.addAttribute("mess", "Them moi thanh cong");
        }
        return "blog/create";
    }
}
