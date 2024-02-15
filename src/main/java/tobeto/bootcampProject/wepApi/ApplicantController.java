package tobeto.bootcampProject.wepApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcampProject.core.entities.User;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.Instructor;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    private ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }
    @RequestMapping("/getall")
    public List<Applicant> findAll() {
        List<Applicant> applicants=applicantRepository.findAll();
        return applicants;
    }

    @RequestMapping("/save")
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

    }

}
