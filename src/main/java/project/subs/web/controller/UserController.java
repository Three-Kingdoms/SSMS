package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.subs.bean.User;
import project.subs.bean.UserSubs;
import project.subs.service.MyInfoService;
import project.subs.service.SubsService;
import project.subs.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyInfoService myInfoService;

    @Autowired
    private SubsService subsService;

    @RequestMapping("/verify/register")
    @ResponseBody
    public String verify(User user) {
        if (userService.verify(user.getUsername()) != null) {
            return "error";
        } else {
            userService.saveUser(user);
            return "success";
        }
    }

    @RequestMapping("/verify/login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request, HttpSession session) {
        User user = userService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "success";
        } else {
//            request.setAttribute("fail", "用户名或密码错误");
            return "error";
        }
    }

    @RequestMapping("/info")
    public String myInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<UserSubs> userSubsList = subsService.findUserSubsByUserId(user.getId());
        session.setAttribute("userSubsList", userSubsList);
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
