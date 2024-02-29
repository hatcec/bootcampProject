package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.employee.EmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByEmailResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcampProject.entity.Employee;
import tobeto.bootcampProject.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream()
                .map(employee -> modelMapperService.forResponse()
                        .map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(getAllEmployeeResponses);
    }

    @Override
    public DataResult<GetByIdEmployeeResponse> getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdEmployeeResponse response = modelMapperService.forResponse()
                .map(employee, GetByIdEmployeeResponse.class);
        return new SuccessDataResult<GetByIdEmployeeResponse>(response);
    }

    @Override
    public DataResult<EmployeeResponse> add(CreateEmployeeRequest employeeRequest) {
        Employee employee = modelMapperService.forRequest().map(employeeRequest, Employee.class);//mapped
        employee.setCreatedAt(LocalDateTime.now());
        this.employeeRepository.save(employee);
        EmployeeResponse response=modelMapperService.forResponse().map(employee, EmployeeResponse.class);
        return new SuccessDataResult<EmployeeResponse>(response);
    }

    @Override
    public DataResult<EmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);//mapped
        this.employeeRepository.save(employee);
        EmployeeResponse response=modelMapperService.forResponse().map(employee, EmployeeResponse.class);
        return new SuccessDataResult<EmployeeResponse>(response);
    }

    @Override
    public Result delete(int id) {
        employeeRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public GetByEmailResponse getByEmail(String email) {
        User user = (User) employeeRepository.getByEmail(email);
        GetByEmailResponse response = modelMapperService.forResponse()
                .map(user, GetByEmailResponse.class);
        return response;

    }
}
