package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.concretes.ApplicantManager;
import tobeto.bootcampProject.business.concretes.ApplicantManager2;
import tobeto.bootcampProject.entity.Applicant;

import java.util.List;

@RestController
@RequestMapping("/applicantsde")
@AllArgsConstructor
public class controller {
    private final ApplicantManager2 entityService;
    @GetMapping
    public List<Applicant> getAllEntities() {
        return entityService.findAll();
    }
}
