package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicationstate.CreateApplicationStateRequest;
import tobeto.bootcampProject.business.requests.applicationstate.UpdateApplicationStateRequest;
import tobeto.bootcampProject.business.responses.applicationstate.GetAllApplicationStatesResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetByIdApplicationStateResponse;

import java.util.List;

public interface ApplicationStateService {
    List<GetAllApplicationStatesResponse> getAll();
    GetByIdApplicationStateResponse getById(int id);
    void add(CreateApplicationStateRequest applicationStateRequest);
    void update(UpdateApplicationStateRequest applicationStateRequest);
    void delete(int id);
}
