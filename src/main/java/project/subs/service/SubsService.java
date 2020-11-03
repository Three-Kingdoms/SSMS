package project.subs.service;

import org.springframework.stereotype.Service;
import project.subs.bean.GroupMember;
import project.subs.bean.User;

import java.util.List;

@Service
public interface SubsService {
    List<GroupMember> findGroupId(User user);
}
