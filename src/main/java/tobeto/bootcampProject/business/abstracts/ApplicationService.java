package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.application.CreateApplicationRequest;
import tobeto.bootcampProject.business.requests.application.UpdateApplicationRequest;
import tobeto.bootcampProject.business.responses.applicant.ApplicantResponse;
import tobeto.bootcampProject.business.responses.application.ApplicationResponse;
import tobeto.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import tobeto.bootcampProject.business.responses.application.GetByIdApplicationResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;

import java.util.List;

public interface ApplicationService {
    DataResult<List<GetAllApplicationsResponse>> getAll();

    DataResult<GetByIdApplicationResponse> getByID(int id);

    DataResult<ApplicationResponse> add(CreateApplicationRequest applicationRequest);

    DataResult<ApplicationResponse> update(UpdateApplicationRequest applicationRequest);

    Result delete(int id);
}
