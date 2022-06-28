package blog2.demo.controller;

import blog2.demo.dto.BlogDTO;
import blog2.demo.model.Blog;
import blog2.demo.model.Category;
import blog2.demo.service.IBlogService;
import blog2.demo.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categlistoryService;

    @ModelAttribute("categoryList")
    public List<Category> getList() {
        return categlistoryService.findAll();
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
        model.addAttribute("categoryIdSearch", categoryIdSearchValue);
        Page<Blog> blogs = blogService.findAll(PageRequest.of(page, 5), titleSearchValue, categoryIdSearchValue);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        return "blog/create";
    }

    @PostMapping("create")
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
