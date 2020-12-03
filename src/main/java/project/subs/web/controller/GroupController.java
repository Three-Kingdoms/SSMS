package project.subs.web.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import project.subs.bean.*;
import project.subs.service.GroupMemberService;
import project.subs.service.GroupService;
import project.subs.service.ServiceService;
import project.subs.service.SubsService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupMemberService groupMemberService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private SubsService subsService;


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

    /**
     *
     */
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

    /**
     * 加入小组多人小组成功，返回此页面
     *
     * @return
     */
    @RequestMapping("/success")
    public String addSuccess() {
        return "group/add-success";
    }

    /**
     * 显示创建多人小组的选择服务信息
     *
     * @return
     */
    @RequestMapping("/createGroup")
    public String createGroup(HttpSession session) {
        //查询自己已经订阅的服务
        User user = (User) session.getAttribute("user");
        List<UserSubs> userSubs = subsService.findUserSubsByUserId(user.getId());
        //剔除重复的服务名
        List<String> serviceNames = new ArrayList<>();
        for (UserSubs subs : userSubs) {
            if (subs.getService().getServiceType() == ServiceType.multi) {
                String serviceName = subs.getService().getServiceName();
                serviceNames.add(serviceName);
            }
        }
        HashSet<String> serviceName = new HashSet<>(serviceNames);
        serviceNames.clear();
        serviceNames.addAll(serviceName);
        session.setAttribute("serviceName", serviceName);
        return "group/create-group";
    }

    /**
     * 根据服务名查询订阅账号
     *
     * @param serviceName
     * @param session
     * @return
     */
    @RequestMapping("/findSubsAccount")
    public String findSubsAccount(String serviceName, HttpSession session) {
        System.out.println(serviceName);
        User user = (User) session.getAttribute("user");
        Service service = serviceService.findByServiceNameAndAndServiceType(serviceName, ServiceType.multi);
        List<UserSubs> subs = subsService.findUserSubsByServiceIdAndUserId(service.getId(), user.getId());
        for (UserSubs userSubs : subs) {
            System.out.println(userSubs);
        }
        session.setAttribute("subsAccount", subs);
        return "group/create-group-account";
    }

    /**
     * 创建多人订阅小组
     *
     * @param session
     * @param groupName
     * @param serviceName
     * @param subsAccount
     * @param maxMember
     * @return
     */
    @RequestMapping("/createSubsGroup")
    @ResponseBody
    public String createSubsGroup(HttpSession session, String groupName, String serviceName, String subsAccount, Integer maxMember) {
        //查出多人订阅服务
        Service service = serviceService.findByServiceNameAndAndServiceType(serviceName, ServiceType.multi);

        //根据登录的user,serviceId,subsAccount，查出对应的usersubs
        User user = (User) session.getAttribute("user");
        UserSubs subs = subsService.findUserSubsByUserIdAndServiceIdAndSubsAccount(user.getId(), service.getId(), subsAccount);

        //保存此多人小组
        Group group = new Group(groupName, GroupType.multiGroup, maxMember, subs, LocalDateTime.now());
        groupService.saveSubsGroup(group);

        //创建多人小组的同时，把自己设置为小组管理员
        GroupMember groupMember = new GroupMember(group, user, true, LocalDateTime.now());
        groupMemberService.save(groupMember);
        return "success";
    }

    @RequestMapping("/add")
    public String addGroup(HttpSession session) {
        List<Service> serviceList = subsService.findMultiServiceName();
        session.setAttribute("serviceList", serviceList);
        return "group/add-group";
    }

    /**
     * 根据服务id去用户订阅表查userSubsId,再根据userSubsId去小组表查对应的小组
     *
     * @param serviceId
     * @return
     */
    @RequestMapping("/findGroupByServiceId")
    public String findGroupByServiceId(Integer serviceId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //根据服务号去查所有此服务的
        List<UserSubs> subs = subsService.findUserSubsByServiceId(serviceId);

        //此服务所有的小组
        List<Group> multiGroups = groupService.findGroupsByUserSubsIn(subs);

        List<GroupMember> hasJoinedGroups = groupMemberService.hasJoinedGroups(user.getId());

        //用于存放没有加入的小组
        List<Group> notJoinedGroupList = new ArrayList<>();;
        List<Group> joinedGroupList = new ArrayList<>();
//        //存放我已加入的小组的人数
//        List<List<GroupMember>> joinedGroupHaveMembers =  new ArrayList<>();
//        //存放未加入的小组的现有人数
//        List<List<GroupMember>> notJoinedGroupHaveMembers =  new ArrayList<>();

        //查询自己否在查询的小组内
        for ( Group group : multiGroups ) {
            for (GroupMember hasJoinGroup: hasJoinedGroups ) {
                if(group.getId().equals(hasJoinGroup.getGroup().getId())){
                    joinedGroupList.add(group);
                    //查询已加入的小组的现有人数
//                    joinedGroupHaveMembers.add(groupMemberService.findGroupMemberByGroupId(group.getId()));
                }
            }
        }

        //查询未加入的小组
        for ( Group group : multiGroups ) {
            notJoinedGroupList.add(group);
            for (Group hasJoinGroup: joinedGroupList ) {
                if(group.getId().equals(hasJoinGroup.getId())){
                    notJoinedGroupList.remove(group);
                }
            }
        }

//        //查询未加入的小组的现有人数
//        for (Group group:notJoinedGroupList
//        ) {
//            notJoinedGroupHaveMembers.add(groupMemberService.findGroupMemberByGroupId(group.getId()));
//        }

//        for ( Group group: joinedGroupList) {
//           List<GroupMember> members = groupMemberService.findGroupMemberByGroupId(group.getId());
//
//        }

        session.setAttribute("multiGroups",multiGroups);
        session.setAttribute("notJoinedGroupList",notJoinedGroupList);
//        session.setAttribute("notJoinedGroupHaveMembers",notJoinedGroupHaveMembers);
        session.setAttribute("joinedGroupList",joinedGroupList);
//        session.setAttribute("joinedGroupHaveMembers",joinedGroupHaveMembers);
        return "group/add-find-group-type";
    }
}
