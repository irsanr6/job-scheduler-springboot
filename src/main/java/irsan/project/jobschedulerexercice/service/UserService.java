package irsan.project.jobschedulerexercice.service;

import irsan.project.jobschedulerexercice.dao.JobTriggerDao;
import irsan.project.jobschedulerexercice.dao.UserDao;
import irsan.project.jobschedulerexercice.model.JobTriggerModel;
import irsan.project.jobschedulerexercice.model.UserModel;
import irsan.project.jobschedulerexercice.utils.Helpers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final JobTriggerDao jobTriggerDao;

    @Bean
    public String cronExpression() {
        log.info("Get cron expression from database");
        Optional<JobTriggerModel> jobTriggerModel = jobTriggerDao.findByCodeJobTrigger("AA");
        if (jobTriggerModel.isPresent()) {
            JobTriggerModel jobTrigger = jobTriggerModel.get();
            return jobTrigger.getCronExpression();
        }
        return "0/30 * * * * *";
    }

    @Scheduled(cron = "#{@cronExpression}", zone = "Asia/Jakarta")
    public void addUserJob() {

        String name = Helpers.addStripeToUsername(Helpers.makeRandomUsername());
        Optional<UserModel> userModel = userDao.findById(1L);
        if (userModel.isPresent()) {
            UserModel model = userModel.get();
            model.setUsername(name + new Random().nextInt(231));
            model.setInsertDatetime(Helpers.currentDate());
            userDao.save(model);
            log.info("Success update User");
        } else {
            log.info("User not present");
        }
        log.info("Add service call in: {}", Helpers.currentDate());

    }

}
