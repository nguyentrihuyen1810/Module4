package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Division;
import com.example.demo.model.Education_degree;
import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import com.example.demo.service.IDivisionService;
import com.example.demo.service.IEducationDegreeService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IEducationDegreeService educationDegreeService;

    @Autowired
    IDivisionService divisionService;

    @ModelAttribute("positionList")
    public List<Position> positionList () {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<Education_degree> educationDegreeList () {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisionList")
    public List<Division> divisionList () {
        return divisionService.findAll();
    }

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> employeeNameSearch, Optional<String> positionIdSearch,
                          Optional<String> educationDegreeIdSearch, Optional<String> divisionIdSearch) {
        String employeeNameSearchValue = "";
        String positionIdSearchValue = "";
        String educationDegreeIdSearchValue = "";
        String divisionIdSearchValue = "";
        if(employeeNameSearch.isPresent()) {
            employeeNameSearchValue = employeeNameSearch.get();
        }
        if(positionIdSearch.isPresent()) {
            positionIdSearchValue = positionIdSearch.get();
        }
        if(educationDegreeIdSearch.isPresent()) {
            educationDegreeIdSearchValue = educationDegreeIdSearch.get();
        }
        if(divisionIdSearch.isPresent()) {
            divisionIdSearchValue = divisionIdSearch.get();
        }
        model.addAttribute("employeeNameSearch", employeeNameSearchValue);
        model.addAttribute("positionIdSearch", positionIdSearchValue);
        model.addAttribute("educationDegreeIdSearch", educationDegreeIdSearchValue);
        model.addAttribute("divisionIdSearch", divisionIdSearchValue);
        Page<Employee> employees = employeeService.findByAll(PageRequest.of(page, 4), employeeNameSearchValue, positionIdSearchValue,
                educationDegreeIdSearchValue, divisionIdSearchValue);
        model.addAttribute("employees", employees);
        return "furama/employee/list";
    }

    @GetMapping("create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "furama/employee/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated EmployeeDTO employeeDTO, BindingResult bindingResult, Model model){
        Employee employee = new Employee();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "furama/employee/create";
        }else {
            BeanUtils.copyProperties(employeeDTO, employee);
            employeeService.save(employee);
            model.addAttribute("employeeDTO", employeeDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/home/employee";
    }

    @GetMapping("edit")
    public String showEditEmployee(Model model, @RequestParam int id) {
        Employee employee = employeeService.findById(id).orElse(null);
        model.addAttribute("employeeDTO", employee);
        return "furama/employee/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        employeeService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/home/employee";
    }
}
