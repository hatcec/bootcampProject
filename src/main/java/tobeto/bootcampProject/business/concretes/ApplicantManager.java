package tobeto.bootcampProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcampProject.entity.Applicant;

import java.util.List;
@Service
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository applicantRepository;
    @Autowired
    public ApplicantManager(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }




}
