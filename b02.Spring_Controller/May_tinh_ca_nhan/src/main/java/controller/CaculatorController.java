package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("/caculator")
    public String myCal() {
        return "index";
    }

    @PostMapping("/caculator")
    public ModelAndView myCaculator(@RequestParam double number1,
                                    @RequestParam double number2,
                                    @RequestParam String operator) {
        double total = 0;
        switch (operator) {
            case "+":
                total = number1 + number2;
                break;
            case "-" :
                total = number1 - number2;
                break;
            case "*":
                total = number1 * number2;
                break;
            case "/":
                total = number1 / number2;
                break;
        }
        return new ModelAndView ("index", "total", total);
    }
}
