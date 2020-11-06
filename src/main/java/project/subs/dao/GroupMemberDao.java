package project.subs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project.subs.bean.GroupMember;

import java.util.List;

@Transactional
public interface GroupMemberDao extends JpaRepository<GroupMember, Integer> {
    List<GroupMember> findGroupMembersByUserId(Integer userId);

    List<GroupMember> findGroupMembersByGroupId(Integer groupId);
//    List<GroupMember> findGroupMembersByGroupIn(List<Group> groups);

    /**
     * 删除单个小组成员
     *
     * @param userId
     * @param groupId
     */
    void deleteByUserIdAndGroupId(Integer userId, Integer groupId);

    /**
     * 查找单个小组成员
     *
     * @param userId
     * @param groupId
     * @return
     */
    GroupMember findGroupMemberByUserIdAndGroupId(Integer userId, Integer groupId);

    /**
     * 解散小组
     *
     * @param groupId
     */
    void deleteGroupMembersByGroupId(Integer groupId);
}
