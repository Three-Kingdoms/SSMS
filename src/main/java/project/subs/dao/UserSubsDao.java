package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.UserSubs;

import java.util.List;

public interface UserSubsDao extends JpaRepository<UserSubs, Integer> {
    UserSubs findUserSubsById(Integer id);
    List<UserSubs> findUserSubsByUserId(Integer userId);
}
