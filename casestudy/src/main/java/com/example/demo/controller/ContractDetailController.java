package com.example.demo.controller;

import com.example.demo.dto.ContractDTO;
import com.example.demo.dto.ContractDetailDTO;
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
@RequestMapping("home/contractDetail")
public class ContractDetailController {
    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IAttachService attachService;

    @Autowired
    IContractService contractService;

    @ModelAttribute("attachServiceList")
    public List<Attach_service> attachServiceList() {
        return attachService.findAll();
    }

    @ModelAttribute("contractList")
    public Page<Contract> findAllCustomer (Pageable pageable) {
        return contractService.findAll(pageable);
    }

    @GetMapping("")
    public String getList(Model model, @RequestParam(defaultValue = "0") int page,
                          Optional<String> contractIdSearch, Optional<String> contractDetailQuantitySearch) {
        String contractIdSearchValue = "";
        String contractDetailQuantitySearchValue = "";
        if(contractIdSearch.isPresent()) {
            contractIdSearchValue = contractIdSearch.get();
        }
        if(contractDetailQuantitySearch.isPresent()) {
            contractDetailQuantitySearchValue = contractDetailQuantitySearch.get();
        }
        model.addAttribute("contractIdSearch", contractIdSearchValue);
        model.addAttribute("contractDetailQuantitySearch", contractDetailQuantitySearchValue);
        Page<Contract_detail> contractDetails = contractDetailService.findByAll(PageRequest.of(page, 4), contractIdSearchValue, contractDetailQuantitySearchValue);
        model.addAttribute("contractDetails", contractDetails);
        return "furama/contractDetail/list";
    }

    @GetMapping("create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDetailDTO", new ContractDetailDTO());
        return "furama/contractDetail/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated ContractDetailDTO contractDetailDTO, BindingResult bindingResult, Model model){
        Contract_detail contractDetail = new Contract_detail();
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "Add not successfully!");
            return "furama/contractDetail/create";
        }else {
            BeanUtils.copyProperties(contractDetailDTO, contractDetail);
            contractDetailService.save(contractDetail);
            model.addAttribute("contractDetailDTO", contractDetailDTO);
            model.addAttribute("mess", "Add successfully!");
        }
        return "redirect:/home/contractDetail";
    }

    @GetMapping("edit")
    public String showEditContract(Model model, @RequestParam int id) {
        Contract_detail contractDetail = contractDetailService.findById(id).orElse(null);
        model.addAttribute("contractDetailDTO", contractDetail);
        return "furama/contractDetail/edit";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        contractDetailService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "Delete successfully!");
        return "redirect:/home/contractDetail";
    }
}
