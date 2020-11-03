package project.subs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.subs.bean.User;

import javax.servlet.http.HttpSession;

// @Controller 让当前类被 Spring 所管理
@Controller
// 这个类专用用来做视图映射的，将逻辑视图名映射成物理视图名。【返回页面的】
public class ViewController {

    @RequestMapping("/login")
    public String login(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "user/login";
        else return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping({"/", "/index", "/my-subs"})
    public String index(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/navigation")
    public String navigation() {
        return "common/navigation";
    }

}
