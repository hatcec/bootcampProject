package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Application;
import tobeto.bootcampProject.entity.BootCamp;

public interface BootCampRepository extends JpaRepository<BootCamp,Integer> {
}
