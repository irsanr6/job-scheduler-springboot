package irsan.project.jobschedulerexercice.controller;

import irsan.project.jobschedulerexercice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author: Irsan Ramadhan
 * @email: irsan.ramadhan@iconpln.co.id
 */
@RestController
@RequestMapping("/api/v1/scheduler")
@RequiredArgsConstructor
public class SchedulerController {

    private static final String SCHEDULED_TASKS = "scheduledTasks";

    private final ScheduledAnnotationBeanPostProcessor postProcessor;
    private final UserService userService;

    @GetMapping("/stop")
    public String stopSchedule() {
        postProcessor.postProcessBeforeDestruction(userService, SCHEDULED_TASKS);
        return "STOP";
    }

    @GetMapping("/start")
    public String startSchedule() {
        postProcessor.postProcessAfterInitialization(userService, SCHEDULED_TASKS);
        return "START";
    }

    @GetMapping("/list")
    public String listSchedules() {
        Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
        if (!setTasks.isEmpty()) {
            return setTasks.toString();
        } else {
            return "Currently no scheduler tasks are running";
        }
    }

}
