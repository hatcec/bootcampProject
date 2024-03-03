package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUserName(String name);
}
