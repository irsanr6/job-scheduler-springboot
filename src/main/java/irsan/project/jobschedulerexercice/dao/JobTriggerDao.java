package irsan.project.jobschedulerexercice.dao;

import irsan.project.jobschedulerexercice.model.JobTriggerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author: Irsan Ramadhan
 * @email: irsan.ramadhan@iconpln.co.id
 */
public interface JobTriggerDao extends JpaRepository<JobTriggerModel, String> {

    Optional<JobTriggerModel> findByCodeJobTrigger(String codeJobTrigger);

}
