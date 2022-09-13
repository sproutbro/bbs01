package com.example.bbs.bbs;

import com.example.bbs.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class BbsController {
    @GetMapping({"/main", ""})
    public String main() {
        return "/page/main";
    }

    @GetMapping("/bbs")
    public String bbs() {
        return "/page/bbs";
    }
}
