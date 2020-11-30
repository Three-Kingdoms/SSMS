package project.subs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.subs.bean.Group;
import project.subs.bean.GroupMember;
import project.subs.bean.User;
import project.subs.bean.UserSubs;
import project.subs.dao.GroupDao;
import project.subs.dao.GroupMemberDao;
import project.subs.service.GroupMemberService;
import project.subs.service.GroupService;
import project.subs.service.SubsService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SubsApplicationTests {

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private SubsService subsService;

    @Autowired
    GroupService groupService;

    @Autowired
    GroupMemberService groupMemberService;

    @Test
    void test4(){
        List<UserSubs> subs = subsService.findUserSubsByServiceId(4);

        //此服务所有的小组
        List<Group> multiGroups = groupService.findGroupsByUserSubsIn(subs);

        List<GroupMember> hasJoinedGroups = groupMemberService.hasJoinedGroups(19);

        //用于存放没有加入的小组
        List<Group> notJoinedGroupList = new ArrayList<>();;
        List<Group> joinedGroupList = new ArrayList<>();
        List<List<GroupMember>> groupExistMembers =  new ArrayList<>();
        List<List<GroupMember>> groupNotExistMembers =  new ArrayList<>();
        //查询自己否在查询的小组内
        for ( Group group : multiGroups ) {
            for (GroupMember hasJoinGroup: hasJoinedGroups ) {
                if(group.getId().equals(hasJoinGroup.getGroup().getId())){
                    joinedGroupList.add(group);
                    List<GroupMember> members = groupMemberService.findGroupMemberByGroupId(group.getId());
                    groupExistMembers.add(members);
                }
            }
        }

        for (List<GroupMember> list:groupExistMembers
             ) {
            System.out.println("已加入的小组现有："+list.size());
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

        System.out.println("没加入的");
        for (Group group:notJoinedGroupList
             ) {
            groupNotExistMembers.add(groupMemberService.findGroupMemberByGroupId(group.getId()));
        }
        for (List<GroupMember> list:
        groupNotExistMembers){
            System.out.println(list.size());
        }

//        List<GroupMember> groupMembersByGroupIn = groupMemberService.findGroupMembersByGroupIn(joinedGroupList);
//        System.out.println(groupMembersByGroupIn);
//        for (GroupMember groupMember:
//             groupMembersByGroupIn) {
//            System.out.println(groupMember);
//        }


    }
    @Test
    void contextLoads() {
//        2020-11-06 20:34:56
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = df.format(date);

        LocalDateTime joinTime = LocalDateTime.now();

        User user = new User();
        user.setId(17);

        Group group = new Group();
        group.setId(13);

        GroupMember member = new GroupMember(group, user, false, joinTime);
        groupMemberDao.save(member);


////        groupMemberDao.saveGroupMember(13,17,0, java.sql.Date.valueOf(str));
    }

}
