package irsan.project.jobschedulerexercice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_scheduled")
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
}
