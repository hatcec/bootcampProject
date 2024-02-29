package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.ApplicationStateService;
import tobeto.bootcampProject.business.requests.applicationstate.CreateApplicationStateRequest;
import tobeto.bootcampProject.business.requests.applicationstate.UpdateApplicationStateRequest;
import tobeto.bootcampProject.business.responses.applicationstate.ApplicationStateResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetAllApplicationStatesResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetByIdApplicationStateResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.ApplicationStateRepository;
import tobeto.bootcampProject.entity.ApplicationState;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {
    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllApplicationStatesResponse>> getAll() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();

        List<GetAllApplicationStatesResponse> applicationStatesResponses = applicationStates.stream()
                .map(applicationState -> modelMapperService.forRequest()
                        .map(applicationState, GetAllApplicationStatesResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationStatesResponse>>(applicationStatesResponses,"");
    }

    @Override
    public DataResult<GetByIdApplicationStateResponse> getById(int id) {
        ApplicationState applicationState = applicationStateRepository.findById(id).orElseThrow();
        GetByIdApplicationStateResponse applicationStateResponse = modelMapperService.forResponse()
                .map(applicationState, GetByIdApplicationStateResponse.class);
        return new SuccessDataResult<GetByIdApplicationStateResponse>(applicationStateResponse);
    }

    @Override
    public DataResult<ApplicationStateResponse> add(CreateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
        ApplicationStateResponse applicationStateResponse=modelMapperService.forResponse().map(applicationState, ApplicationStateResponse.class);
        return new SuccessDataResult<ApplicationStateResponse>(applicationStateResponse);
    }

    @Override
    public DataResult<ApplicationStateResponse> update(UpdateApplicationStateRequest applicationStateRequest) {
        ApplicationState applicationState = modelMapperService.forRequest().map(applicationStateRequest, ApplicationState.class);
        this.applicationStateRepository.save(applicationState);
        ApplicationStateResponse applicationStateResponse=modelMapperService.forResponse().map(applicationState, ApplicationStateResponse.class);
        return new SuccessDataResult<ApplicationStateResponse>(applicationStateResponse);
    }

    @Override
    public Result delete(int id) {
        applicationStateRepository.deleteById(id);
       return new SuccessResult("Deleted Successfull !") ;
    }
}