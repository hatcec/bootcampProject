package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.BlackListService;
import tobeto.bootcampProject.business.requests.blacklist.CreateBlackListRequest;
import tobeto.bootcampProject.business.requests.blacklist.UpdateBlackListRequest;
import tobeto.bootcampProject.business.responses.applicant.GetAllApplicantResponse;
import tobeto.bootcampProject.business.responses.applicant.GetByIdApplicantResponse;
import tobeto.bootcampProject.business.responses.blacklist.BlackListResponse;
import tobeto.bootcampProject.business.responses.blacklist.GetAllBlackListResponse;
import tobeto.bootcampProject.business.responses.blacklist.GetByIdBlackListResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.BlackListRepository;
import tobeto.bootcampProject.entity.Applicant;
import tobeto.bootcampProject.entity.BlackList;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {
    private ModelMapperService modelMapperService;
    private BlackListRepository blackListRepository;
    @Override
    public DataResult<List<GetAllBlackListResponse>> getAll() {
        List<BlackList> blackLists=blackListRepository.findAll();
        List<GetAllBlackListResponse> getAllBlackListResponses=blackLists.stream()
                .map(blackList -> modelMapperService.forResponse()
                        .map(blackList, GetAllBlackListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBlackListResponse>>(getAllBlackListResponses,"Listele");
    }

    @Override
    public DataResult<GetByIdBlackListResponse> getById(int id) {
        BlackList blackList = blackListRepository.findById(id).orElseThrow();
        GetByIdBlackListResponse response = modelMapperService.forResponse()
                .map(blackList, GetByIdBlackListResponse.class);
        return new SuccessDataResult<GetByIdBlackListResponse>(response);
    }

    @Override
    public DataResult<BlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
        BlackList blackList=modelMapperService.forResponse().map(createBlackListRequest, BlackList.class);
        blackListRepository.save(blackList);
        BlackListResponse blackListResponse=modelMapperService.forResponse().map(blackList, BlackListResponse.class);
        return new SuccessDataResult<BlackListResponse>(blackListResponse);
    }

    @Override
    public DataResult<BlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
        BlackList blackList=modelMapperService.forResponse().map(updateBlackListRequest, BlackList.class);
        blackListRepository.save(blackList);
        BlackListResponse blackListResponse=modelMapperService.forResponse().map(blackList, BlackListResponse.class);
        return new SuccessDataResult<BlackListResponse>(blackListResponse);
    }

    @Override
    public Result delete(int id) {
        blackListRepository.deleteById(id);
        return new SuccessResult("deleted success");
    }
}
