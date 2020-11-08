package project.subs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.subs.bean.Group;
import project.subs.bean.GroupMember;
import project.subs.bean.User;
import project.subs.service.GroupMemberService;
import project.subs.service.GroupService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupMemberService groupMemberService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/info")
    public String groupInfo(Integer groupId, HttpSession session) {

        //查询小组成员
        List<GroupMember> groupMembers = groupMemberService.findGroupMemberByGroupId(groupId);
        session.setAttribute("groupMembers", groupMembers);

        //查询单个小组
        Group group = groupService.findGroupByGroupId(groupId);
        session.setAttribute("group", group);

        //查询单个小组成员，用来判断是否是小组管理员
        User user = (User) session.getAttribute("user");
        GroupMember member = groupMemberService.findGroupMemberByUserIdAndGroupId(user.getId(), groupId);
        session.setAttribute("member", member);

        return "group/group-info";
    }

    /**
     * 根据小组成员id和小组id,移除此小组成员
     *
     * @param userId
     * @param groupId
     */
    @RequestMapping("/remove")
    @ResponseBody
    public void deleteGroupMember(Integer userId, Integer groupId) {
        groupMemberService.deleteGroupMemberByUserIdAndGroupId(userId, groupId);
    }

    /**
     * 根据小组id和组长id,解散此小组，并将所有此小组的成员移除
     *
     * @param groupId
     * @return
     */
    @ResponseBody
    @RequestMapping("/dissolve")
    public void dissolveGroup(Integer groupId) {
        groupService.deleteGroupBygroupId(groupId);
    }

    /**
     * 退出小组
     *
     * @param userId
     * @param groupId
     */
    @RequestMapping("/exit")
    @ResponseBody
    public void exitGroup(Integer userId, Integer groupId) {
        groupMemberService.deleteGroupMemberByUserIdAndGroupId(userId, groupId);
    }

    @RequestMapping("/find")
    public String findGroup(Integer groupId, HttpSession session) {
        System.out.println("搜索的小组号：" + groupId);
        Group group = groupService.findGroupByGroupId(groupId);
        //因为已存在session-group,所有这里以exitGroup表示搜索到的单个group
        session.setAttribute("exitGroup", group);
        System.out.println(group);
        List<GroupMember> members = groupMemberService.findGroupMemberByGroupId(groupId);
        session.setAttribute("exitMembers", members);

        //查询自己是否在查询的小组内
        User user = (User) session.getAttribute("user");
        GroupMember myself = groupMemberService.findGroupMemberByUserIdAndGroupId(user.getId(), groupId);
        session.setAttribute("myself", myself);

        return "group/add-find-group";
    }


    @RequestMapping("/addGroup")
    public String addGroup(HttpSession session, Integer groupId) {
        User user = (User) session.getAttribute("user");
        Group group = new Group();
        group.setId(groupId);
        LocalDateTime joinTime = LocalDateTime.now();
        groupMemberService.save(new GroupMember(group, user, false, joinTime));
        return "group/add-group";
    }


    @RequestMapping("/success")
    public String addSuccess() {
        return "group/add-success";
    }

    @RequestMapping("/add")
    public String addGroup() {
        return "group/add-group";
    }


}
