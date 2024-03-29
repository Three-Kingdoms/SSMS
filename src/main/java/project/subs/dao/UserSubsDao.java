package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.UserSubs;

import java.util.List;

public interface UserSubsDao extends JpaRepository<UserSubs, Integer> {
    List<UserSubs> findUserSubsByUserId(Integer userId);

    UserSubs findUserSubsById(Integer id);

    List<UserSubs> findUserSubsByServiceIdAndUserId(Integer serviceId, Integer userId);

    UserSubs findUserSubsByUserIdAndServiceIdAndSubsAccount(Integer userId, Integer serviceId, String subsAccount);

    List<UserSubs> findUserSubsByServiceId(Integer serviceId);
}
