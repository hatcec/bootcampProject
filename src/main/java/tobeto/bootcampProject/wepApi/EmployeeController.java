package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByEmailResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
   private EmployeeService employeeService;


    @RequestMapping("/getall")
    public List<GetAllEmployeeResponse> findAll(){
        return  employeeService.getAll();
    }
    @GetMapping("/{id}")//variable al pathden okur
    public GetByIdEmployeeResponse getById(@PathVariable int id) {
        return employeeService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateEmployeeRequest employeeRequest){
        employeeService.add(employeeRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateEmployeeRequest updateEmployeeRequest){
        employeeService.update(updateEmployeeRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }
    @GetMapping("/{email}")
    public GetByEmailResponse getByEmail(@PathVariable String email){
        return employeeService.getByEmail(email);
    }
}
