package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
