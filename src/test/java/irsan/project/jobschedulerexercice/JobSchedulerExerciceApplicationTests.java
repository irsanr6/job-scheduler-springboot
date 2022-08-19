package irsan.project.jobschedulerexercice;

import irsan.project.jobschedulerexercice.dao.JobTriggerDao;
import irsan.project.jobschedulerexercice.dao.UserDao;
import irsan.project.jobschedulerexercice.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
@Slf4j
class JobSchedulerExerciceApplicationTests {

    @Autowired
    private JobTriggerDao jobTriggerDao;
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
//        String dateString = new Date().toString();
//        Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(dateString);
//        DateFormat target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//        target.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Jakarta")));
//        log.info("currentDate {}", target.format(date));
        Date date = new Date();
        log.info("currentDate {}", date);
    }

    @Test
    void cronExpression() {
        log.info("Get cron expression from database: {}", jobTriggerDao.findByCodeJobTrigger("AA").get().getCronExpression());
    }

    @Test
    void getUser() {
        Optional<UserModel> optional = userDao.findById(1L);
        if (optional.isPresent()) {
            UserModel model = optional.get();
            log.info("User {}", model);
        } else {
            log.info("No data found");
        }
    }

}
