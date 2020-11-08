package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project.subs.bean.Group;
import project.subs.bean.UserSubs;

import java.util.List;

@Transactional
public interface GroupDao extends JpaRepository<Group, Integer> {

    List<Group> findGroupsByUserSubsIn(List<UserSubs> userSubs);

    Group findGroupById(Integer groupId);

    void deleteGroupById(Integer id);


}
