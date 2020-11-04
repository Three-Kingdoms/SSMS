package project.subs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.subs.bean.ServiceType;
import project.subs.bean.UserSubs;
import project.subs.dao.GroupDao;
import project.subs.dao.ServiceDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class SubsApplicationTests {

    @Autowired
    private ServiceDao serviceDao;
    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        LocalDateTime startTime = LocalDateTime.parse("2020-11-11T00:00");
        LocalDateTime endTime = LocalDateTime.parse("2020-11-30T00:00");
        UserSubs userSubs = new UserSubs(null, null, null, startTime, endTime, "");
        System.out.println(userSubs);
    }

}
