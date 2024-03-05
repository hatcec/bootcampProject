package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.BootCampService;
import tobeto.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import tobeto.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import tobeto.bootcampProject.business.responses.bootcamp.BootcampResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetByIdBootcampResponse;
import tobeto.bootcampProject.business.rules.ApplicationBusinessRules;
import tobeto.bootcampProject.business.rules.BootcampBusinessRules;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampRepository;
import tobeto.bootcampProject.entity.BootCamp;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootCampManager implements BootCampService {
    private BootCampRepository bootcampRepository;
    private ModelMapperService modelMapperService;
    private ApplicationBusinessRules applicationBusinessRules;
    @Override
    public DataResult<List<GetAllBootcampsResponse>> getAll() {
        List<BootCamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampsResponse> getAllBootcampsResponses = bootcamps.stream()
                .map(bootcamp -> modelMapperService.forResponse()
                        .map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampsResponse>>(getAllBootcampsResponses);
    }

    @Override
    public DataResult<GetByIdBootcampResponse> getById(int id) {
        BootCamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetByIdBootcampResponse bootcampResponse = modelMapperService.forResponse()
                .map(bootcamp, GetByIdBootcampResponse.class);
        return new SuccessDataResult<GetByIdBootcampResponse>(bootcampResponse);
    }

    @Override
    public DataResult<BootcampResponse> add(CreateBootcampRequest bootcampRequest) {
        BootCamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, BootCamp.class);
        this.bootcampRepository.save(bootcamp);
        BootcampResponse response=modelMapperService.forResponse().map(bootcamp, BootcampResponse.class);
        return new SuccessDataResult<BootcampResponse>(response);
    }

    @Override
    public DataResult<BootcampResponse> update(UpdateBootcampRequest bootcampRequest) {
        BootCamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, BootCamp.class);
        bootcampRepository.save(bootcamp);
        BootcampResponse response=modelMapperService.forResponse().map(bootcamp, BootcampResponse.class);
        return new SuccessDataResult<BootcampResponse>(response);
    }

    @Override
    public Result delete(int id) {
        bootcampRepository.deleteById(id);
        return new SuccessResult("deleted !");
    }
}