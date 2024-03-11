package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.applicant.ApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetByIdApplicantResponse;
import tobeto.bootcampProject.business.rules.UserBusinessRules;
import tobeto.bootcampProject.core.aspects.logging.Loggable;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcampProject.entity.Applicant;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules bootcampBusinessRules;


    @Override
    @Loggable
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();
        List<GetAllApplicantResponse> getAllApplicantResponses = applicants.stream()
                .map(applicant -> modelMapperService.forResponse()
                        .map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicantResponse>>(getAllApplicantResponses, "listele");
    }

    @Override
    public DataResult<GetByIdApplicantResponse> getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdApplicantResponse response = modelMapperService.forResponse()
                .map(applicant, GetByIdApplicantResponse.class);
        return new SuccessDataResult<GetByIdApplicantResponse>(response);
    }

    @Override
    public DataResult<ApplicantResponse> add(CreateApplicantRequest applicantRequest) {
        bootcampBusinessRules.checkIfUserNameExists(applicantRequest.getUserName());
        Applicant applicant = modelMapperService.forRequest().map(applicantRequest, Applicant.class);//mapped
        this.applicantRepository.save(applicant);
        ApplicantResponse response = modelMapperService.forResponse().map(applicant, ApplicantResponse.class);
        return new SuccessDataResult<ApplicantResponse>(response);
    }

    @Override
    public DataResult<ApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant = modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
        applicantRepository.save(applicant);
        ApplicantResponse response = modelMapperService.forRequest().map(applicant, ApplicantResponse.class);
        return new SuccessDataResult<ApplicantResponse>(response);
    }

    @Override
    public Result delete(int id) {
        applicantRepository.deleteById(id);
        return new SuccessResult("deleted success");
    }



}

