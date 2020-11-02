package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.User;
import project.subs.dao.UserDao;
import project.subs.service.MyInfoService;

import javax.servlet.http.HttpSession;


@Service
public class MyInfoServiceImpl implements MyInfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public String updateNickname(HttpSession session, Integer userId, String newNickname) {
        User user = userDao.findUserById(userId);
        user.setNickname(newNickname);
        userDao.save(user);
        session.setAttribute("user",user);
        return "success";
    }

    @Override
    public String updatePassword(HttpSession session, Integer userId,String oldPassword ,String newPassword) {
        User user = userDao.findUserById(userId);
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            userDao.save(user);
            session.setAttribute("user",user);
            return "success";
        } else return "fail";
    }
}
