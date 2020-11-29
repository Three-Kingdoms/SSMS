package project.subs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.subs.bean.User;
import project.subs.dao.UserDao;
import project.subs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        System.out.println("service层接收数据：" + user);
        userDao.save(user);
    }

    @Override
    public User verify(String username) {
        User user = userDao.findUserByUsername(username);
        System.out.println(user);
        return user;
    }

}
