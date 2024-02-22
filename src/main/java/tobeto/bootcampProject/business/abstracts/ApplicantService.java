package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.applicant.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetByIdApplicantResponse;

import java.util.List;

public interface ApplicantService {
    List<GetAllApplicantResponse> getAll();
    GetByIdApplicantResponse getById(int id);
    void add(CreateApplicantRequest applicantRequest);
    void update(UpdateApplicantRequest updateApplicantRequest);
    void delete(int id);

}
