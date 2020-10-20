package project.subs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupController {

    @RequestMapping("/info")
    public String groupInfo() {
        return "group/group-info";
    }

}
