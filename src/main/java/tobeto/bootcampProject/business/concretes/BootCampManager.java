package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.BootCampService;
import tobeto.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import tobeto.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import tobeto.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetByIdBootcampResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.BootCampRepository;
import tobeto.bootcampProject.entity.BootCamp;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootCampManager implements BootCampService {
    private BootCampRepository bootcampRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllBootcampsResponse> getAll() {
        List<BootCamp> bootcamps = bootcampRepository.findAll();

        List<GetAllBootcampsResponse> getAllBootcampsResponses = bootcamps.stream()
                .map(bootcamp -> modelMapperService.forResponse()
                        .map(bootcamp, GetAllBootcampsResponse.class)).collect(Collectors.toList());

        return getAllBootcampsResponses;
    }

    @Override
    public GetByIdBootcampResponse getById(int id) {
        BootCamp bootcamp = bootcampRepository.findById(id).orElseThrow();
        GetByIdBootcampResponse bootcampResponse = modelMapperService.forResponse()
                .map(bootcamp, GetByIdBootcampResponse.class);
        return bootcampResponse;
    }

    @Override
    public void add(CreateBootcampRequest bootcampRequest) {
        BootCamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, BootCamp.class);
        this.bootcampRepository.save(bootcamp);
    }

    @Override
    public void update(UpdateBootcampRequest bootcampRequest) {
        BootCamp bootcamp = modelMapperService.forRequest().map(bootcampRequest, BootCamp.class);
        bootcampRepository.save(bootcamp);
    }

    @Override
    public void delete(int id) {
        bootcampRepository.deleteById(id);
    }
}