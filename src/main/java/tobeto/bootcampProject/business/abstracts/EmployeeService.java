package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByEmailResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAll();
    GetByIdEmployeeResponse getById(int id);
    CreateEmployeeRequest add(CreateEmployeeRequest employeeRequest);
    UpdateEmployeeRequest update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
    GetByEmailResponse getByEmail(String email);
}
