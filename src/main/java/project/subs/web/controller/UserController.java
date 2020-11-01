package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.subs.web.service.myInfoService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private myInfoService myinfoservice;


    @RequestMapping("/info")
    public String myInfo() {
        return "user/my-info";
    }

    @RequestMapping("/updateNickname")
    public void updateNickname(String newNickname) {
        myinfoservice.saveNewNickname(newNickname);
    }

    @RequestMapping("/updatePassword")
    public void updatePassword(String newPassword) {
        myinfoservice.saveNewPassword(newPassword);
    }

}
