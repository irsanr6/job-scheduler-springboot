package irsan.project.jobschedulerexercice.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;

/**
 * @author: Irsan Ramadhan
 * @email: irsan.ramadhan@iconpln.co.id
 */
@Slf4j
public class Helpers {

    private static final char CHAR = '-';
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String addStripeToUsername(String str) {
        return str.substring(0, 3) + Helpers.CHAR + str.substring(3);
    }

    public static String makeRandomUsername() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(Helpers.ALPHABET.length());
            char randomChar = Helpers.ALPHABET.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static Date currentDate() {
        Date date = new Date();
//        Reformat date to string
//        Date date = new Date().toString();
//        Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(dateString);
//        DateFormat target = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
//        target.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Asia/Jakarta")));
//        log.info("currentDate {}", target.format(date));
        return date;
    }

}
