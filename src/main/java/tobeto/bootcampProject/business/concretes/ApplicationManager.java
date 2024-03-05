package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.ApplicationService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.CreateApplicationRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.responses.application.ApplicationResponse;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;
import tobeto.bootcampProject.business.rules.ApplicationBusinessRules;
import tobeto.bootcampProject.core.exceptions.types.BlacklistException;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcampProject.dataAccess.abstracts.BlackListRepository;
import tobeto.bootcampProject.entity.Application;
import tobeto.bootcampProject.entity.BlackList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;
    private ApplicationBusinessRules applicationBusinessRules;
    @Override

    public DataResult<List<GetAllApplicationsResponse>> getAll() {
        List<Application> applications = applicationRepository.findAll();

        List<GetAllApplicationsResponse> allApplicationsResponses = applications.stream()
                .map(application -> modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationsResponse>>(allApplicationsResponses,"eklendi");
    }

    @Override
    public DataResult<GetByIdApplicationResponse> getByID(int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        GetByIdApplicationResponse applicationResponse = modelMapperService.forResponse()
                .map(application, GetByIdApplicationResponse.class);
        return new SuccessDataResult<GetByIdApplicationResponse>(applicationResponse);
    }


    @Override
    public DataResult<ApplicationResponse> add(CreateApplicationRequest applicationRequest) {
        /*Optional<BlackList> optionalBlackList=blackListRepository.findById(applicationRequest.getApplicantId());
        if(optionalBlackList!=null){
            throw  new BlacklistException("kursa başvuramazsınız blacklisttesiniz!");
        }**/
        /*applicationBusinessRules.checkIfApplicantIdExists(applicationRequest.getApplicantId());
        applicationBusinessRules.checkIfUserNameExists(applicationRequest.getApplicantId());*/
        Application application = modelMapperService.forRequest().map(applicationRequest,Application.class);
        this.applicationRepository.save(application);
        ApplicationResponse response=modelMapperService.forResponse().map(application, ApplicationResponse.class);
        return new SuccessDataResult<ApplicationResponse>(response,"eklendi");
    }



    @Override
    public DataResult<ApplicationResponse> update(UpdateApplicationRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest, Application.class);
        applicationRepository.save(application);
        ApplicationResponse response=modelMapperService.forResponse().map(application, ApplicationResponse.class);
        return new SuccessDataResult<ApplicationResponse>(response,"güncellendi!");
    }

    @Override
    public Result delete(int id) {
        applicationRepository.deleteById(id);
        return new SuccessResult("deleted success");
    }


}