package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.business.responses.blacklist.BlackListResponse;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.BlackList;
import tobeto.bootcampProject.entity.User;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
    BlackList getByApplicantId(int id);
}
