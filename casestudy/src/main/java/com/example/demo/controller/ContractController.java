package com.example.demo.controller;

import com.example.demo.dto.ContractDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("home/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IServiceService serviceService;

    @ModelAttribute("employeeList")
    public Page<Employee> findAllEmployee (Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @ModelAttribute("customerList")
    public Page<Customer> findAllCustomer (Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @ModelAttribute("serviceList")
    public Page<Service> findAllService (Pageable pageable) {
        return serviceService.findAll(pageable);
    }

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> contractStartDateSearch, Optional<String> contractEndDateSearch) {
        String contractStartDateSearchValue = "";
        String contractEndDateSearchValue = "";
        if(contractStartDateSearch.isPresent()) {
            contractStartDateSearchValue = contractStartDateSearch.get();
        }
        if(contractEndDateSearch.isPresent()) {
            contractEndDateSearchValue = contractEndDateSearch.get();
        }
        model.addAttribute("contractStartDateSearch", contractStartDateSearchValue);
        model.addAttribute("contractEndDateSearch", contractEndDateSearchValue);
        Page<Contract> contracts = contractService.findByAll(PageRequest.of(page, 4), contractStartDateSearchValue, contractEndDateSearchValue);
        model.addAttribute("contracts", contracts);
        return "furama/contract/list";
    }

    @GetMapping("create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDTO", new ContractDTO());
        return "furama/contract/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated ContractDTO contractDTO, BindingResult bindingResult, Model model){
        Contract contract = new Contract();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "furama/contract/create";
        }else {
            BeanUtils.copyProperties(contractDTO, contract);
            contractService.save(contract);
            model.addAttribute("contractDTO", contractDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/home/contract";
    }

    @GetMapping("edit")
    public String showEditContract(Model model, @RequestParam int id) {
        Contract contract = contractService.findById(id).orElse(null);
        model.addAttribute("contractDTO", contract);
        return "furama/contract/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        contractService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/home/contract";
    }
}
