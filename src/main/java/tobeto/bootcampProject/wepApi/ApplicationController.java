package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicationService;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;
import tobeto.bootcampProject.business.responses.employee.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.employee.GetByIdEmployeeResponse;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController {
    private ApplicationService applicationService;


    @RequestMapping("/getall")
    public List<GetAllApplicationsResponse> findAll(){
        return  applicationService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateApplicantRequest applicantRequest){
        applicationService.add(applicantRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateApplicationRequest updateApplicationRequest){
        applicationService.update(updateApplicationRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        applicationService.delete(id);
    }
}
