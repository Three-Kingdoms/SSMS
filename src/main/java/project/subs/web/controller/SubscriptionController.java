package project.subs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    @RequestMapping("/my")
    public String mySubscription() {
        return "subscription/my-subscription";
    }

    @RequestMapping("/add")
    public String addSubscription() {
        return "subscription/add-subscription";
    }

    @RequestMapping("/multi")
    public String multiUserSubscription() {
        return "subscription/multi-user-subscription";
    }

    @RequestMapping("/info")
    public String subscriptionInfo() {
        return "subscription/subscription-info";
    }

}
