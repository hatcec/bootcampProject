package tobeto.bootcampProject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampRepository;
@AllArgsConstructor
@Service
public class BootcampBusinessRules { //singleton oluşturucaz
    private BootCampRepository bootCampRepository;
    /* public void checkIfApplicantExist(String name){
        if(bootCampRepository.existByName(name)){
            throw  new BusinessException("her kursa bir defa başvuru yapabilirsiniz.");
        }
    }*/
}
