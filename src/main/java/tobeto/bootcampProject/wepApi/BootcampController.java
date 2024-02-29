package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicationService;
import tobeto.bootcampProject.business.abstracts.BootCampService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import tobeto.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import tobeto.bootcampProject.business.rules.BootcampBusinessRules;

@RestController
@RequestMapping("/bootcamps")
@AllArgsConstructor
public class BootcampController extends BaseController {
    private BootCampService bootCampService;

    @RequestMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(bootCampService.getAll());
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateBootcampRequest bootcampRequest) {
        return handleDataResult(bootCampService.add(bootcampRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateBootcampRequest updateBootcampRequest) {
        return handleDataResult(bootCampService.update(updateBootcampRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(bootCampService.delete(id));
    }
}
