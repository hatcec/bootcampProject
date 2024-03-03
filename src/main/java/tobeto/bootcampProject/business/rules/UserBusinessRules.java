package tobeto.bootcampProject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.core.exceptions.types.BusinessException;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampRepository;
import tobeto.bootcampProject.dataAccess.abstracts.UserRepository;
import tobeto.bootcampProject.entity.User;

@AllArgsConstructor
@Service
public class UserBusinessRules { //singleton oluşturucaz
    private UserRepository userRepository;
    public  void checkIfUserNameExists(String name){
        User user= userRepository.getByUserName(name);
        if(user!=null){
            throw  new BusinessException("böyle bir username daha önce kullanılmıştır");
        }
    }
}
