package project.subs.service;

import project.subs.bean.User;
import project.subs.bean.UserSubs;

public interface IUserService {
    User findUserByUsername(String username);


    void saveUser(User user);

    User verify(String username);
}
