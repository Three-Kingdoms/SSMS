package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.GroupMember;
import project.subs.bean.ServiceType;
import project.subs.bean.UserSubs;
import project.subs.dao.GroupMemberDao;
import project.subs.dao.ServiceDao;
import project.subs.dao.UserSubsDao;
import project.subs.service.SubsService;

import java.util.List;

@Service
public class SubsServiceImpl implements SubsService {

    @Autowired
    private UserSubsDao userSubsDao;

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Autowired
    private ServiceDao serviceDao;


    @Override
    public UserSubs findUserSubsById(Integer id) {
        return userSubsDao.findUserSubsById(id);
    }

    @Override
    public void saveUserSubs(UserSubs userSubs) {
        userSubsDao.save(userSubs);
    }

    @Override
    public void removeUserSubs(int userSubsId) {
        userSubsDao.deleteById(userSubsId);
    }

    @Override
    public List<UserSubs> findUserSubsByUserId(Integer userId) {
        return userSubsDao.findUserSubsByUserId(userId);
    }

    @Override
    public List<project.subs.bean.Service> findSingleServiceName() {
        ServiceType serviceType= ServiceType.single;
        List<project.subs.bean.Service> singleServiceList = serviceDao.findByServiceType(serviceType);
        return singleServiceList;
    }

    @Override
    public List<project.subs.bean.Service> findMultiServiceName() {
        ServiceType serviceType= ServiceType.multi;
        List<project.subs.bean.Service> multiServiceList = serviceDao.findByServiceType(serviceType);
        return multiServiceList;
    }

    @Override
    public List<GroupMember> findGroupMemberByUserId(Integer userId) {

        return groupMemberDao.findGroupMembersByUserId(userId);
    }
}
