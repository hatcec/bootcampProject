package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Application;

public interface ApplicationRepository extends JpaRepository <Application ,Integer> {
}
