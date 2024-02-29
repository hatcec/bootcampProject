package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.bootcampstate.BootcampStateResponse;
import tobeto.bootcampProject.business.responses.employee.EmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByEmailResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<GetByIdEmployeeResponse> getById(int id);
    DataResult<EmployeeResponse> add(CreateEmployeeRequest employeeRequest);
    DataResult<EmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
    Result delete(int id);
    GetByEmailResponse getByEmail(String email);
}
