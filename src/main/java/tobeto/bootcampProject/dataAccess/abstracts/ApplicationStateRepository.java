package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.ApplicationState;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState,Integer> {
}
