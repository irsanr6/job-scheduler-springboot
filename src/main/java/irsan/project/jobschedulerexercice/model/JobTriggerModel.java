package irsan.project.jobschedulerexercice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: Irsan Ramadhan
 * @email: irsan.ramadhan@iconpln.co.id
 */
@Entity
@Table(name = "job_trigger")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobTriggerModel {

    @Id
    @Column(name = "code_job_trigger")
    private String codeJobTrigger;

    @Column(name = "cron_expression")
    private String cronExpression;

}
