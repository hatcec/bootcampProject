package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.business.responses.GetByEmailResponse;
import tobeto.bootcampProject.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<GetByEmailResponse> getByEmail(String email);
}
