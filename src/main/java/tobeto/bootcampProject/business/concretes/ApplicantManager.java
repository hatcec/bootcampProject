package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.ApplicantService;
import tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import tobeto.bootcampProject.core.entities.utilities.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcampProject.entity.Applicant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ApplicantRepository applicantRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllApplicantResponse> getAll() {
        List<Applicant> applicants=applicantRepository.findAll();

        List<GetAllApplicantResponse> getAllApplicantResponses=applicants.stream()
                .map(applicant->modelMapperService.forResponse()
                        .map(applicant,GetAllApplicantResponse.class)).collect(Collectors.toList());

        return getAllApplicantResponses;
    }

    @Override
    public GetByIdApplicantResponse getById(int id) {
        Applicant applicant=applicantRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdApplicantResponse response=modelMapperService.forResponse()
                .map(applicant,GetByIdApplicantResponse.class);
        return response;
    }

    @Override
    public void add(CreateApplicantRequest applicantRequest) {
        /*Applicant applicant=new Applicant();
        applicant.setAbout(applicantRequest.getAbout());
        applicant.setUserName(applicantRequest.getUserName());*/
        Applicant applicant=modelMapperService.forRequest().map(applicantRequest,Applicant.class);//mapped
        this.applicantRepository.save(applicant);
    }

    @Override
    public void update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant=modelMapperService.forRequest().map(updateApplicantRequest,Applicant.class);
        applicantRepository.save(applicant);//id elimde olduğu için update eder.
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }


}

