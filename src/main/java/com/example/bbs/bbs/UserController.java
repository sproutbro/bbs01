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

    private UserService userService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/login")
    public String loginAction(Model model, User user) {
        int result = userService.login(user.getUserID(), user.getUserPassword());
        if(result == 1) {
            return "main";
        }
        else if(result == 0) {
            model.addAttribute("msg", "비밀번호가 틀립니다.");
        }
        else if(result == -1) {
            model.addAttribute("msg", "존재하지 않는 아이디 입니다.");
        }
        return "login";
    }

    @PostMapping("/join")
    public String joinAction(Model model, User user) {
        int result = userService.join(user);
        System.out.println("result = " + result);
        return "join";
    }
}
