package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.applicant.ApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetByIdApplicantResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<GetByIdApplicantResponse> getById(int id);

    DataResult<ApplicantResponse> add(CreateApplicantRequest applicantRequest);

    DataResult<ApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);

    Result delete(int id);

}
