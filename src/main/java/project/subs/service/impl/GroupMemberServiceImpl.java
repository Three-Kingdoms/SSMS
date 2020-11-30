package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.Group;
import project.subs.bean.GroupMember;
import project.subs.dao.GroupMemberDao;
import project.subs.service.GroupMemberService;

import java.util.List;

@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Override
    public List<GroupMember> findGroupMemberByGroupId(Integer groupId) {
        return groupMemberDao.findGroupMembersByGroupId(groupId);
    }

    @Override
    public void deleteGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId) {
        groupMemberDao.deleteByUserIdAndGroupId(userId, groupId);
    }

    @Override
    public GroupMember findGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId) {
        return groupMemberDao.findGroupMemberByUserIdAndGroupId(userId, groupId);
    }

    @Override
    public List<GroupMember> hasJoinedGroups(Integer userId) {
        return groupMemberDao.findGroupMembersByUserId(userId);
    }

    @Override
    public void save(GroupMember groupMember) {
        groupMemberDao.save(groupMember);
    }

    @Override
    public List<GroupMember> findGroupMembersByGroupIn(List<Group> groups) {
        return groupMemberDao.findGroupMembersByGroupIn(groups);
    }


}
