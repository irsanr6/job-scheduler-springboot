package irsan.project.jobschedulerexercice.dao;

import irsan.project.jobschedulerexercice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, Long> {
}
