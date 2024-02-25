package tobeto.bootcampProject.business.concretes;

import tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import tobeto.bootcampProject.business.requests.applicationstate.CreateApplicationStateRequest;
import tobeto.bootcampProject.business.requests.applicationstate.UpdateApplicationStateRequest;
import tobeto.bootcampProject.business.responses.applicationstate.GetAllApplicationStatesResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetByIdApplicationStateResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import tobeto.bootcampProject.entity.ApplicationState;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllApplicationStatesResponse> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();

        List<GetAllApplicationStatesResponse> applicationStatesResponses = applicationStates.stream()
                .map(applicationState -> modelMapperService.forRequest()
                        .map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());
        return applicationStatesResponses;
    }

    @Override
    public GetByIdApplicationStateResponse getById(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        GetByIdApplicationStateResponse applicationStateResponse = modelMapperService.forResponse()
                .map(applicationState, GetByIdApplicationStateResponse.class);
        return applicationStateResponse;
    }

    @Override
    public void add(CreateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
    }

    @Override
    public void update(UpdateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
    }

    @Override
    public void delete(int id) {
        applicationStateRepository.deleteById(id);
    }
}