package tobeto.bootcampProject.business.concretes;

import tobeto.bootcampProject.business.abstracts.ApplicationService;
import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcampProject.entity.Application;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationManager implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private ModelMapperService modelMapperService;
    @Override

    public List<GetAllApplicationsResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();

        List<GetAllApplicationsResponse> allApplicationsResponses = applications.stream()
                .map(application -> modelMapperService.forResponse()
                        .map(application, GetAllApplicationsResponse.class)).collect(Collectors.toList());

        return allApplicationsResponses;
    }

    @Override
    public GetByIdApplicationResponse getByID(int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        GetByIdApplicationResponse applicationResponse = modelMapperService.forResponse()
                .map(application, GetByIdApplicationResponse.class);
        return applicationResponse;
    }

    @Override
    public void add(CreateApplicantRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest,Application.class);
        this.applicationRepository.save(application);
    }

    @Override
    public void update(UpdateApplicationRequest applicationRequest) {
        Application application = modelMapperService.forRequest().map(applicationRequest, Application.class);
        applicationRepository.save(application);
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById(id);
    }
}