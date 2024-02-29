package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicationService;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.CreateApplicationRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;

import java.util.List;

@RestController
@RequestMapping("/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController {
    private ApplicationService applicationService;
    @RequestMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(applicationService.getAll());
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateApplicationRequest applicationRequest) {
       return handleDataResult(applicationService.add(applicationRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateApplicationRequest updateApplicationRequest) {
       return handleDataResult(applicationService.update(updateApplicationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return  handleResult(applicationService.delete(id));
    }
}
