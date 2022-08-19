package irsan.project.jobschedulerexercice.dao;

import irsan.project.jobschedulerexercice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findById(Long id);

}
