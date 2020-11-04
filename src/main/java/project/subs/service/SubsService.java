package project.subs.service;

import org.springframework.stereotype.Service;
import project.subs.bean.GroupMember;
import project.subs.bean.User;
import project.subs.bean.UserSubs;


import java.util.List;

@Service
public interface SubsService {
    UserSubs findUserSubsById(Integer id);
    void saveUserSubs(UserSubs userSubs);
    List<UserSubs> findUserSubsByUserId(Integer userId);
    List<project.subs.bean.Service> findSingleServiceName();
    List<project.subs.bean.Service> findMultiServiceName();
    List<GroupMember> findGroupId(User user);

}