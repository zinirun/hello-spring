package zini.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //GET METHOD
    public String hello(Model model){
        // key, value
        model.addAttribute("data", "spring!!");
        // resources > templates > hello.html
        return "hello";
    }
}
