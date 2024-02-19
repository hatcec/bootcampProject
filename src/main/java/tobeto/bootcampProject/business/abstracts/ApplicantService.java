package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.UpdateApplicantRequest;
import tobeto.bootcampProject.business.responses.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.GetByIdApplicantResponse;
import tobeto.bootcampProject.entity.Applicant;

import java.util.List;

public interface ApplicantService {
    List<GetAllApplicantResponse> getAll();
    GetByIdApplicantResponse getById(int id);
    void add(CreateApplicantRequest applicantRequest);
    void update(UpdateApplicantRequest updateApplicantRequest);
    void delete(int id);

}
