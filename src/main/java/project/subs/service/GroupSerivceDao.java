package project.subs.service;

import project.subs.bean.Group;

public interface GroupSerivceDao {
    Group findGroupByGroupId(Integer groupId);

    void deleteGroupBygroupId(Integer groupId);
}
