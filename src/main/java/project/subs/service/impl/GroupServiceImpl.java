package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.Group;
import project.subs.dao.GroupDao;
import project.subs.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Group findGroupByGroupId(Integer groupId) {
        return groupDao.findGroupById(groupId);
    }

    @Override
    public void deleteGroupBygroupId(Integer groupId) {
        groupDao.deleteGroupById(groupId);
    }
}
