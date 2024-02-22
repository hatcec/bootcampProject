package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Application;
import tobeto.bootcampProject.entity.BootCampState;

public interface BootCampStateRepository extends JpaRepository<BootCampState,Integer> {
}
