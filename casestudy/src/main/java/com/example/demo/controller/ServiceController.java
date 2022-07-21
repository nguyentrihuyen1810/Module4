package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ServiceDTO;
import com.example.demo.model.*;
import com.example.demo.service.IRentTypeService;
import com.example.demo.service.IServiceService;
import com.example.demo.service.IServiceTypeService;
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
@RequestMapping("home/service")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @ModelAttribute("serviceTypeList")
    public List<Service_type> serviceTypeList() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<Rent_type> rentTypeList() {
        return rentTypeService.findAll();
    }

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> serviceNameSearch, Optional<String> serviceTypeIdSearch) {
        String serviceNameSearchValue = "";
        String serviceTypeIdSearchValue = "";
        if(serviceNameSearch.isPresent()) {
            serviceNameSearchValue = serviceNameSearch.get();
        }
        if(serviceTypeIdSearch.isPresent()) {
            serviceTypeIdSearchValue = serviceTypeIdSearch.get();
        }
        model.addAttribute("serviceNameSearch", serviceNameSearchValue);
        model.addAttribute("serviceTypeIdSearch", serviceTypeIdSearchValue);
        Page<Service> services = serviceService.findByAll(PageRequest.of(page, 4), serviceNameSearchValue, serviceTypeIdSearchValue);
        model.addAttribute("services", services);
        return "furama/service/list";
    }

    @GetMapping("create")
    public String showCreateService(Model model) {
        model.addAttribute("serviceDTO", new ServiceDTO());
        return "furama/service/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated ServiceDTO serviceDTO, BindingResult bindingResult, Model model){
        Service service = new Service();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "furama/service/create";
        }else {
            BeanUtils.copyProperties(serviceDTO, service);
            serviceService.save(service);
            model.addAttribute("serviceDTO", serviceDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/home/service";
    }

    @GetMapping("edit")
    public String showEditService(Model model, @RequestParam int id) {
        Service service = serviceService.findById(id).orElse(null);
        model.addAttribute("serviceDTO", service);
        return "furama/service/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        serviceService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/home/service";
    }
}
