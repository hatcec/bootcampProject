package tobeto.bootcampProject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.core.exceptions.types.BusinessException;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcampProject.dataAccess.abstracts.BlackListRepository;
import tobeto.bootcampProject.entity.Application;
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
    public  void checkIfUserNameExists(int id){
        Application application= applicationRepository.getByApplicantId(id);
        if(application!=null){
            throw  new BusinessException("Bu eğitime daha önce başvuru yaptınız.");
        }
    }
}
