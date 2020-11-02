package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {
     User findUserByUsername(String username);
     User findUserById(Integer userId);
}
