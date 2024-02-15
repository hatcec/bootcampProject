package tobeto.bootcampProject.wepApi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @RequestMapping("/getall")
    public List<Employee> findAll(){
        List<Employee> employees=employeeRepository.findAll();
        return  employees;
    }
    @RequestMapping("/save")
    public Employee employee() {
        Employee employee = new Employee();
        employee.setUserName("hatice");
        employee.setFirstName("hatice");
        employee.setLastName("ates");
        employee.setEmail("h@gmail.com");
        employee.setPosition("IT");
        employee.setPassword("11111");
        employeeRepository.save(employee);
        return employee;
    }
}
