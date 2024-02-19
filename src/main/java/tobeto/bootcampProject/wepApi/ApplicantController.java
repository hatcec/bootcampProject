package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;

import java.util.List;

@RestController
@RequestMapping("/applicants")
@AllArgsConstructor
public class ApplicantController {
   // private ApplicantRepository applicantRepository;
    private ApplicantService applicantService;

   /* public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }*/

    /*public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }*/

    @RequestMapping("/getall")
    public List<GetAllApplicantResponse> findAll() {
        return applicantService.getAll();
      /* benm yaptığım
      List<Applicant> applicants=applicantRepository.findAll();
        return applicants;*/
    }

   /* @RequestMapping("/save")
    public Applicant applicant() {
        Applicant applicant=new Applicant();
        applicant.setUserName("hatice");
        applicant.setFirstName("hatice");
        applicant.setLastName("ates");
        applicant.setEmail("h@gmail.com");
        applicant.setAbout("deneme");
        applicant.setPassword("11111");
        applicantRepository.save(applicant);
        return applicant;

    }*/
   @GetMapping("/{id}")//variable al pathden okur
   public GetByIdApplicantResponse getById(@PathVariable int id) {
       return applicantService.getById(id);

   }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateApplicantRequest applicantRequest){
         applicantService.add(applicantRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateApplicantRequest updateApplicantRequest){
       applicantService.update(updateApplicantRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
       applicantService.delete(id);
    }

}
