package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassController {
    @GetMapping("/customers")
    public String showList() {
        return "customers/list.jsp";
    }
}
