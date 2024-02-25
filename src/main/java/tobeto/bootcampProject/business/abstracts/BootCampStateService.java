package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.bootcampstate.CreateBootcampStateRequest;
import tobeto.bootcampProject.business.requests.bootcampstate.UpdateBootcampStateRequest;
import tobeto.bootcampProject.business.responses.bootcampstate.GetAllBootcampStatesResponse;
import tobeto.bootcampProject.business.responses.bootcampstate.GetByIdBootcampStateResponse;

import java.util.List;

public interface BootCampStateService {
    List<GetAllBootcampStatesResponse> getAll();
    GetByIdBootcampStateResponse getById(int id);
    void add(CreateBootcampStateRequest bootcampStateRequest);
    void update(UpdateBootcampStateRequest bootcampStateRequest);
    void delete(int id);
}
