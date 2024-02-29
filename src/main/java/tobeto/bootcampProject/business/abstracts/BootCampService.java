package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import tobeto.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import tobeto.bootcampProject.business.responses.bootcamp.BootcampResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetByIdBootcampResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BootCampService {
    DataResult<List<GetAllBootcampsResponse>> getAll();
    DataResult<GetByIdBootcampResponse> getById(int id);
    DataResult<BootcampResponse> add(CreateBootcampRequest bootcampRequest);
    DataResult<BootcampResponse>  update(UpdateBootcampRequest bootcampRequest);
    Result delete(int id);
}
