package project.subs.service;

import project.subs.bean.Group;
import project.subs.bean.UserSubs;

import java.util.List;

public interface GroupService {
    Group findGroupByGroupId(Integer groupId);

    void deleteGroupBygroupId(Integer groupId);

    void saveSubsGroup(Group group);

    List<Group> findGroupsByUserSubsIn(List<UserSubs> userSubs);


}
