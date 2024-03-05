package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.business.responses.application.ApplicationResponse;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.Application;
import tobeto.bootcampProject.entity.BootCamp;

public interface ApplicationRepository extends JpaRepository <Application ,Integer> {
    Application getByApplicantId(int id);
}
