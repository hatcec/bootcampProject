package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<GetAllEmployeeResponse> getAll();
    GetByIdEmployeeResponse getById(int id);
    CreateEmployeeRequest add(CreateEmployeeRequest employeeRequest);
    UpdateEmployeeRequest update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
}
