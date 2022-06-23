package irsan.project.jobschedulerexercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobSchedulerExerciceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSchedulerExerciceApplication.class, args);
    }

}
