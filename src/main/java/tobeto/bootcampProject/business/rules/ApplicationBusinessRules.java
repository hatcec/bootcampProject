package tobeto.bootcampProject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.core.exceptions.types.BusinessException;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcampProject.dataAccess.abstracts.BlackListRepository;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.BlackList;
@AllArgsConstructor
@Service
public class ApplicationBusinessRules {

    private BlackListRepository blackListRepository;
    public ApplicationRepository applicationRepository;
    public  void checkIfApplicantIdExists(int id){
        BlackList blackList=blackListRepository.getByApplicantId(id);
        if(blackList!=null){
            throw  new BusinessException("bu öğrenci blacklistte olduğu için kampa başvuru yapamaz.");
        }
    }
    public  void checkIfUserNameExists(String name){
        Applicant applicant= applicationRepository.existByName(name);
        if(applicant!=null){
            throw  new BusinessException("Bu eğitime daha önce başvuru yaptınız.");
        }
    }
}
