package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Map<String, Object> model) {
        model.put("content", "This is an initial message");
        return "main";
    }
}
