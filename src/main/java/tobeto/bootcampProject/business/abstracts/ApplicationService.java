package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;

import java.util.List;

public interface ApplicationService {
    List<GetAllApplicationsResponse> getAll();
    GetByIdApplicationResponse getByID(int id);

    void add(CreateApplicantRequest applicationRequest);
    void update(UpdateApplicationRequest applicationRequest);
    void delete(int id);
}
