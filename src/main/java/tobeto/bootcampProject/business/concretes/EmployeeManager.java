package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;
import tobeto.bootcampProject.core.entities.utilities.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees=employeeRepository.findAll();
        List<GetAllEmployeeResponse> getAllEmployeeResponses=employees.stream()
                .map(employee->modelMapperService.forResponse()
                        .map(employee,GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return getAllEmployeeResponses;
    }

    @Override
    public GetByIdEmployeeResponse getById(int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdEmployeeResponse response=modelMapperService.forResponse()
                .map(employee,GetByIdEmployeeResponse.class);
        return response;
    }

    @Override
    public CreateEmployeeRequest add(CreateEmployeeRequest employeeRequest) {
        Employee employee=modelMapperService.forRequest().map(employeeRequest,Employee.class);//mapped
        this.employeeRepository.save(employee);
        return employeeRequest;
    }

    @Override
    public UpdateEmployeeRequest update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee=modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);//mapped
        this.employeeRepository.save(employee);
        return updateEmployeeRequest;
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
