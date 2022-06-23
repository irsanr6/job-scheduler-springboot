package irsan.project.jobschedulerexercice.service;

import irsan.project.jobschedulerexercice.dao.UserDao;
import irsan.project.jobschedulerexercice.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    // schedule a job to add object in DB (every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void addUserJob() {
        //    make random string
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();

        UserModel userModel = new UserModel();
        userModel.setUsername(randomString.toLowerCase()+ new Random().nextInt(231));

        userDao.save(userModel);

        log.info("Add service call in: {}", new Date().toString());

    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDbJob() {

        List<UserModel> userModels = userDao.findAll();

        log.info("Fetch service call in: {}", new Date().toString());
        log.info("No of record fetched: {}", userModels.size());
        log.info("Users: {}", userModels);
    }

}
