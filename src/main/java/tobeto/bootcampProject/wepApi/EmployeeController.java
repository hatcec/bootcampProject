package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class EmployeeController extends  BaseController{
   private EmployeeService employeeService;


    @RequestMapping("/getall")
    public ResponseEntity<?> findAll(){
        return handleDataResult(employeeService.getAll());
    }
    @GetMapping("/{id}")//variable al pathden okur
    public  ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(employeeService.getById(id));
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public   ResponseEntity<?> add(@RequestBody() CreateEmployeeRequest employeeRequest){
       return handleDataResult(employeeService.add(employeeRequest));
    }
    @PutMapping
    public  ResponseEntity<?> update(@RequestBody() UpdateEmployeeRequest updateEmployeeRequest){
       return handleDataResult(employeeService.update(updateEmployeeRequest));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable int id){
      return handleResult(employeeService.delete(id));
    }
    @GetMapping("/{email}")
    public GetByEmailResponse getByEmail(@PathVariable String email){
        return employeeService.getByEmail(email);
    }
}
