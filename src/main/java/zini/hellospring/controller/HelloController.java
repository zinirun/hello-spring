package zini.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // STATIC
    @GetMapping("hello") //GET METHOD
    public String hello(Model model){
        // key, value
        model.addAttribute("data", "spring");
        // resources > templates > hello.html
        return "hello";
    }

    // MVC
    @GetMapping("hello-mvc") // RequestParam(value="name", required=false)
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API (String)
    @GetMapping("hello-string")
    @ResponseBody //템플릿을  찾지않고 데이터를 넘김
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // API (JSON)
    @GetMapping("hello-api")
    @ResponseBody // hello 객체를 json 스타일로 바꿈
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
