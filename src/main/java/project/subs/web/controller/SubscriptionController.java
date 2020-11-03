package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.subs.bean.ServiceType;
import project.subs.bean.User;
import project.subs.bean.UserSubs;
import project.subs.service.SubsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
@Autowired
private SubsService subsService;

    @RequestMapping("/my")
    public String mySubscription(HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("user - " + user);
        List<UserSubs> userSubsList = subsService.findUserSubsByUserId(user.getId());
        System.out.println("userSubsList - " + userSubsList);
        if (!userSubsList.isEmpty()) {
            List<UserSubs> singleSubs = new ArrayList<>();
            for (UserSubs subs: userSubsList) {
                if (subs.getService().getServiceType().equals(ServiceType.single)) {
                    singleSubs.add(subs);
                }
            }
            session.setAttribute("singleSubs", singleSubs);
            System.out.println("singleSubs - " + singleSubs);
        }
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
    public String subscriptionInfo(HttpServletRequest request) {
        Integer subsId = Integer.parseInt(request.getParameter("subsId"));
        UserSubs subs = subsService.findUserSubsById(subsId);
        String serviceName = subs.getService().getServiceName();
        String subsAccount = subs.getSubsAccount();
        String startTime = subs.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endTime = subs.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String description = subs.getDescription();
        request.setAttribute("subsId", subsId);
        request.setAttribute("serviceName", serviceName);
        request.setAttribute("subsAccount", subsAccount);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("description", description);
        return "subscription/subscription-info";
    }

}
