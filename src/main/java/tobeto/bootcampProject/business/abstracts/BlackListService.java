package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import tobeto.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import tobeto.bootcampProject.business.requests.blacklist.CreateBlackListRequest;
import tobeto.bootcampProject.business.requests.blacklist.UpdateBlackListRequest;
import tobeto.bootcampProject.business.responses.applicant.ApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetByIdApplicantResponse;
import tobeto.bootcampProject.business.responses.blacklist.BlackListResponse;
import tobeto.bootcampProject.business.responses.blacklist.GetAllBlackListResponse;
import tobeto.bootcampProject.business.responses.blacklist.GetByIdBlackListResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface BlackListService {
    DataResult<List<GetAllBlackListResponse>> getAll();

    DataResult<GetByIdBlackListResponse> getById(int id);

    DataResult<BlackListResponse> add(CreateBlackListRequest createBlackListRequest);

    DataResult<BlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);

    Result delete(int id);
}
