package project.subs.service;

import project.subs.bean.GroupMember;

import java.util.List;

public interface GroupMemberService {
    List<GroupMember> findGroupMemberByGroupId(Integer grupId);

    void deleteGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId);

    GroupMember findGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId);
}
