package tobeto.bootcampProject.wepApi;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;


@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController extends BaseController {

    private final  ApplicantService applicantService;

    @GetMapping("/getall")
    public ResponseEntity<?> findAll() {
        return handleDataResult(applicantService.getAll());
    }


    @GetMapping("/{id}")//variable al pathden okur
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(applicantService.getById(id));

    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody() CreateApplicantRequest applicantRequest) {
        return handleDataResult(applicantService.add(applicantRequest));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateApplicantRequest updateApplicantRequest) {
        return handleDataResult(applicantService.update(updateApplicantRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return handleResult(applicantService.delete(id));
    }

}
