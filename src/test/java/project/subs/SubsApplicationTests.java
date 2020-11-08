package project.subs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.subs.bean.Group;
import project.subs.bean.GroupMember;
import project.subs.bean.User;
import project.subs.dao.GroupDao;
import project.subs.dao.GroupMemberDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class SubsApplicationTests {

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Autowired
    private GroupDao groupDao;

    @Test
    void contextLoads() {
//        2020-11-06 20:34:56
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = df.format(date);

        LocalDateTime joinTime = LocalDateTime.now();

        User user = new User();
        user.setId(17);

        Group group = new Group();
        group.setId(13);

        GroupMember member = new GroupMember(group, user, false, joinTime);
        groupMemberDao.save(member);


////        groupMemberDao.saveGroupMember(13,17,0, java.sql.Date.valueOf(str));
    }

}
