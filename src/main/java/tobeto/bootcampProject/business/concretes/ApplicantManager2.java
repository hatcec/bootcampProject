package tobeto.bootcampProject.business.concretes;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.business.abstracts.GenericService;
import tobeto.bootcampProject.entity.Applicant;

public class ApplicantManager2 extends GenericService<Applicant, Integer> {
    public ApplicantManager2(JpaRepository<Applicant, Integer> repository) {
        super(repository);
    }
}
