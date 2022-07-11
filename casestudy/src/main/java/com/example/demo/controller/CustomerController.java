package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;


    @ModelAttribute("customerTypeList")
    public List<Customer_type> customerTypeList () {
        return customerTypeService.findAll();
    }


    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> customerNameSearch, Optional<String> customerTypeIdSearch) {
        String customerNameSearchValue = "";
        String customerTypeIdSearchValue = "";
        if(customerNameSearch.isPresent()) {
            customerNameSearchValue = customerNameSearch.get();
        }
        if(customerTypeIdSearch.isPresent()) {
            customerTypeIdSearchValue = customerTypeIdSearch.get();
        }
        model.addAttribute("customerNameSearch", customerNameSearchValue);
        model.addAttribute("customerTypeIdSearch", customerTypeIdSearchValue);
        Page<Customer> customers = customerService.findByAll(PageRequest.of(page, 4), customerNameSearchValue, customerTypeIdSearchValue);
        model.addAttribute("customers", customers);
        return "furama/customer/list";
    }

    @GetMapping("create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "furama/customer/create";
    }

    @PostMapping("save")
    public String save(Model model, BindingResult bindingResult) {
        Customer customer = new Customer();
        if(bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add new customer not successfully");
            return "/furama/customer/create";
        } else {
//            BeanUtils.copyProperties(customer, customer);
            customerService.save(customer);
            model.addAttribute("customer", customer);
            model.addAttribute("mess", "Add new customer successfully");
        }
        return "redirect:/home/customer";
    }

    @GetMapping("edit")
    public String showEditCustomer(Model model, @RequestParam int id) {
        Customer customer = customerService.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "furama/home/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/home/customer";
    }
}
