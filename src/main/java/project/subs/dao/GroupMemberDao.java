package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.subs.bean.GroupMember;
import project.subs.bean.User;

import java.util.List;

public interface GroupMemberDao extends JpaRepository<GroupMember, Integer> {
    List<GroupMember> findByUser_Id(Integer userId);
}
