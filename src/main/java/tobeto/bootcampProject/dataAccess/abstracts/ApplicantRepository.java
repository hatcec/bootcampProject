package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.Employee;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
