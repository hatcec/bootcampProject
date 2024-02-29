package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicationstate.CreateApplicationStateRequest;
import tobeto.bootcampProject.business.requests.applicationstate.UpdateApplicationStateRequest;
import tobeto.bootcampProject.business.responses.applicationstate.ApplicationStateResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetAllApplicationStatesResponse;
import tobeto.bootcampProject.business.responses.applicationstate.GetByIdApplicationStateResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<List<GetAllApplicationStatesResponse>> getAll();
    DataResult<GetByIdApplicationStateResponse> getById(int id);
    DataResult<ApplicationStateResponse> add(CreateApplicationStateRequest applicationStateRequest);
    DataResult<ApplicationStateResponse> update(UpdateApplicationStateRequest applicationStateRequest);
    Result delete(int id);
}
