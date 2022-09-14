package com.example.bbs.bbs;

import com.example.bbs.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "page/main";
        }
        return "page/login";
    }

    @GetMapping("/join")
    public String join(HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "page/main";
        }
        return "page/join";
    }


    @PostMapping("/login")
    public String loginAction(Model model, User user, HttpSession session) {
        int result = userService.login(user.getUserID(), user.getUserPassword());
        if(result == 1) {
            session.setAttribute("userID", user.getUserID());
            return "page/main";
        }
        else if(result == 0) {
            model.addAttribute("msg", "비밀번호가 틀립니다.");
        }
        else if(result == -1) {
            model.addAttribute("msg", "존재하지 않는 아이디 입니다.");
        }
        return "page/login";
    }

    @PostMapping("/join")
    public String joinAction(Model model, User user, HttpSession session) {
        if(user.getUserID() == "" ||
        user.getUserPassword() == "" ||
        user.getUserName() == "" ||
        user.getUserGender() == "" ||
        user.getUserEmail() == "") {
            model.addAttribute("msg", "입력이 안된 사항이 있습니다.");
            return "page/join";
        }
        if(userService.join(user) == 1) {
            session.setAttribute("userID", user.getUserID());
        }
        return "page/main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "page/main";
    }
}
