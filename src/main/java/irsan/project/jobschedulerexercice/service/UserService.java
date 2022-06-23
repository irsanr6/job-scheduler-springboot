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

    private static final char CHAR = '-';

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String addStripeToUsername(String str, char c, int pos) {

        return str.substring(0, pos) + c + str.substring(pos);

    }

    private static String makeRandomUsername(String chars) {

        String alphabet = chars;

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        int length = 7;

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();

        return randomString;

    }

    // schedule a job to add object in DB (every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void addUserJob() {

        String name = addStripeToUsername(makeRandomUsername(ALPHABET), CHAR, 3);

        UserModel userModel = new UserModel();
        userModel.setUsername(name + new Random().nextInt(231));

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
