package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.BootCampStateService;
import tobeto.bootcampProject.business.requests.bootcampstate.CreateBootcampStateRequest;
import tobeto.bootcampProject.business.requests.bootcampstate.UpdateBootcampStateRequest;
import tobeto.bootcampProject.business.responses.bootcampstate.BootcampStateResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.GetAllBootcampStatesResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.GetByIdBootcampStateResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampStateRepository;
import tobeto.bootcampProject.entity.BootCampState;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BootCampStateManager implements BootCampStateService {
    private BootCampStateRepository bootcampStateRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllBootcampStatesResponse>> getAll() {
        List<BootCampState> bootcampStates = bootcampStateRepository.findAll();

        List<GetAllBootcampStatesResponse> allBootcampStatesResponses = bootcampStates.stream()
                .map(bootcampState -> modelMapperService.forResponse()
                        .map(bootcampState, GetAllBootcampStatesResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBootcampStatesResponse>>(allBootcampStatesResponses);
    }

    @Override
    public DataResult<GetByIdBootcampStateResponse> getById(int id) {
        BootCampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();
        GetByIdBootcampStateResponse bootcampStateResponse = modelMapperService.forResponse()
                .map(bootcampState, GetByIdBootcampStateResponse.class);
        return new SuccessDataResult<GetByIdBootcampStateResponse>(bootcampStateResponse);
    }

    @Override
    public DataResult<BootcampStateResponse> add(CreateBootcampStateRequest bootcampStateRequest) {
        BootCampState bootcampState = modelMapperService.forRequest().map(bootcampStateRequest, BootCampState.class);
        this.bootcampStateRepository.save(bootcampState);
        BootcampStateResponse response=modelMapperService.forResponse().map(bootcampState, BootcampStateResponse.class);
        return new SuccessDataResult<BootcampStateResponse>(response);
    }

    @Override
    public DataResult<BootcampStateResponse> update(UpdateBootcampStateRequest bootcampStateRequest) {
        BootCampState bootcampState = modelMapperService.forRequest().map(bootcampStateRequest,BootCampState.class);
        this.bootcampStateRepository.save(bootcampState);
        BootcampStateResponse response=modelMapperService.forResponse().map(bootcampState, BootcampStateResponse.class);
        return new SuccessDataResult<BootcampStateResponse>(response);
    }

    @Override
    public Result delete(int id) {
        bootcampStateRepository.deleteById(id);
        return new SuccessResult();
    }
}