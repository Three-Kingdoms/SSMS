package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.subs.bean.User;
import project.subs.service.IUserService;
import project.subs.service.MyInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private MyInfoService myInfoService;

    @RequestMapping("/verify/register")
    public String verify(User user, HttpServletRequest request) {
        if (userService.verify(user.getUsername()) != null) {
            request.setAttribute("error", "该账户已存在");
            return "forward:/register";
        } else {
            userService.saveUser(user);
            request.setAttribute("success", "注册成功");
            return "/user/login";
        }
    }

    @RequestMapping("/verify/login")
    public String login(String username, String password, HttpServletRequest request, HttpSession session) {

        User user = userService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            request.setAttribute("fail", "用户名或密码错误");
            return "/user/login";
        }
    }

    @RequestMapping("/info")
    public String myInfo( ) {
        return "/user/my-info";
    }

    @RequestMapping("/updateNickname")
    @ResponseBody
    public String updateNickname(HttpSession session, String newNickname) {
        User user = (User) session.getAttribute("user");

        return myInfoService.updateNickname(session, user.getId(),newNickname);

    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(HttpSession session,String oldPassword, String newPassword) {
        User user = (User) session.getAttribute("user");
        return myInfoService.updatePassword(session,user.getId(),oldPassword,newPassword);
    }

}
