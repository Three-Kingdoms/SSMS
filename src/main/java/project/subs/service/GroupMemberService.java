package project.subs.service;

import project.subs.bean.Group;
import project.subs.bean.GroupMember;

import java.util.List;

public interface GroupMemberService {
    List<GroupMember> findGroupMemberByGroupId(Integer groupId);

    void deleteGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId);

    GroupMember findGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId);

    List<GroupMember> hasJoinedGroups(Integer userId);

    void save(GroupMember groupMember);

    List<GroupMember> findGroupMembersByGroupIn(List<Group> groups);

}
