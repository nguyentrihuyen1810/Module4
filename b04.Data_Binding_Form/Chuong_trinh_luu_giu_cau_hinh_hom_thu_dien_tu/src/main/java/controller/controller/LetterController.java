package controller.controller;

import controller.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LetterController {

    @GetMapping("/edit")
    public ModelAndView setting(){
        return new ModelAndView("setting","choice", Setting.getInstance());
    }

    @PostMapping("/update")
    public String update(Setting setting){
        Setting s= Setting.getInstance();
        s.setLanguage(setting.getLanguage());
        s.setPageSize(setting.getPageSize());
        s.setSpamFilter(setting.isSpamFilter());
        s.setSingature(setting.getSingature());
        return "index";
    }
}
