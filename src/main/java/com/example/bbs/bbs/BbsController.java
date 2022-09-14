package com.example.bbs.bbs;

import com.example.bbs.model.Bbs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class BbsController {

    private BbsService bbsService;

    @GetMapping("/bbs/{pageNumber}")
    public String bbs(Model model, @PathVariable int pageNumber) {
        List<Bbs> bbsList = bbsService.getBbsList(pageNumber);
        model.addAttribute("nextPage", bbsService.getBbsList(pageNumber + 1).isEmpty());
        model.addAttribute("bbsList", bbsList);
        model.addAttribute("pageNumber", pageNumber);
        return "page/bbs";
    }

    @GetMapping("/bbs")
    public String bbsMain() {
        return "redirect:/bbs/1";
    }

    @GetMapping("/view/{bbsID}")
    public String view(Model model, @PathVariable int bbsID) {
        Bbs bbs = bbsService.getBbsByID(bbsID);
        model.addAttribute("bbs", bbs);
        return "page/view";
    }

    @GetMapping("/write")
    public String write(Model model, HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "page/write";
        } else {
            model.addAttribute("msg", "로그인을 하세요.");
            return "page/login";
        }
    }

    @PostMapping("/write")
    public String writeAction(Bbs bbs, HttpSession session, Model model) {
        bbs.setUserID(session.getAttribute("userID").toString());
        model.addAttribute("bbsID", bbsService.writeBbs(bbs));
        return "page/write";
    }

    @GetMapping("/update/{bbsID}")
    public String update(Model model, @PathVariable int bbsID) {
        Bbs bbs = bbsService.getBbsByID(bbsID);
        model.addAttribute("bbs", bbs);
        return "page/update";
    }

    @PostMapping("/update/")
    public String updateAction(Bbs bbs) {
        bbsService.update(bbs);
        return "redirect:/view/" + bbs.getBbsID();
    }

    @GetMapping("/delete/{bbsID}")
    public String deleteBbs(HttpSession session, @PathVariable Integer bbsID) {
        String userID = bbsService.getBbsByID(bbsID).getUserID();
        if(session.getAttribute("userID").equals(userID)) {
            bbsService.deleteBbs(bbsID);
        }
        return "redirect:/bbs";
    }
}
