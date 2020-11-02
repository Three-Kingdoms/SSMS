package project.subs.service;

import project.subs.bean.User;

public interface IUserService {
    User findUserByUsername(String username);

    void saveUser(User user);

    User verify(String username);
}
