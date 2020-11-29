package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.Group;
import project.subs.bean.UserSubs;
import project.subs.dao.GroupDao;
import project.subs.dao.GroupMemberDao;
import project.subs.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Override
    public Group findGroupByGroupId(Integer groupId) {
        return groupDao.findGroupById(groupId);
    }

    @Override
    public void deleteGroupBygroupId(Integer groupId) {
        groupDao.deleteGroupById(groupId);
    }

    @Override
    public void saveSubsGroup(Group group) {
        groupDao.save(group);
    }

    @Override
    public List<Group> findGroupsByUserSubsIn(List<UserSubs> userSubs) {
        return groupDao.findGroupsByUserSubsIn(userSubs);
    }


}
