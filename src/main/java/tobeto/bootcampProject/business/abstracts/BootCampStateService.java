package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.bootcampstate.CreateBootcampStateRequest;
import tobeto.bootcampProject.business.requests.bootcampstate.UpdateBootcampStateRequest;
import tobeto.bootcampProject.business.responses.bootcamp.BootcampResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.BootcampStateResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.GetAllBootcampStatesResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.GetByIdBootcampStateResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BootCampStateService {
    DataResult<List<GetAllBootcampStatesResponse>> getAll();
    DataResult<GetByIdBootcampStateResponse> getById(int id);
    DataResult<BootcampStateResponse> add(CreateBootcampStateRequest bootcampStateRequest);
    DataResult<BootcampStateResponse>  update(UpdateBootcampStateRequest bootcampStateRequest);
    Result delete(int id);
}
