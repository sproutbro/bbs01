package com.example.bbs.bbs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping({"/main", ""})
    public String main() {
        return "page/main";
    }



}
