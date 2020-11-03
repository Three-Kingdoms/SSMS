package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.subs.bean.User;
import project.subs.service.SubsService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
@Autowired
private SubsService subsService;

    @RequestMapping("/my")
    public String mySubscription() {
        return "subscription/my-subscription";
    }

    @RequestMapping("/add")
    public String addSubscription() {
        return "subscription/add-subscription";
    }

    @RequestMapping("/multi")
    public String multiUserSubscription(HttpSession session) {
        User user = (User)session.getAttribute("user");
        subsService.findGroupId(user);

        return "subscription/multi-user-subscription";
    }

    @RequestMapping("/info")
    public String subscriptionInfo() {
        return "subscription/subscription-info";
    }

}
