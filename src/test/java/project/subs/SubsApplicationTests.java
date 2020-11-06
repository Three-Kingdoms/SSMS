package project.subs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.subs.dao.GroupDao;
import project.subs.dao.GroupMemberDao;

@SpringBootTest
class SubsApplicationTests {

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Autowired
    private GroupDao groupDao;

    @Test
    void contextLoads() {
        groupMemberDao.deleteGroupMembersByGroupId(8);
        groupDao.deleteGroupById(8);

    }

}
