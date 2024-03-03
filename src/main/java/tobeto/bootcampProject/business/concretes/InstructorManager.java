package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.InstructorService;
import tobeto.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.GetByIdInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.InstructorResponse;
import tobeto.bootcampProject.business.rules.UserBusinessRules;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;
import tobeto.bootcampProject.core.results.SuccessDataResult;
import tobeto.bootcampProject.core.results.SuccessResult;
import tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcampProject.entity.Instructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;
    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors=instructorRepository.findAll();
        List<GetAllInstructorResponse> getAllInstructorResponses=instructors.stream()
                .map(instructor->modelMapperService.forResponse()
                        .map(instructor,GetAllInstructorResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorResponse>>(getAllInstructorResponses) ;
    }

    @Override
    public DataResult<GetByIdInstructorResponse> getById(int id) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdInstructorResponse response=modelMapperService.forResponse()
                .map(instructor,GetByIdInstructorResponse.class);
        return new SuccessDataResult<GetByIdInstructorResponse>(response);
    }

    @Override
    public DataResult<InstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
        userBusinessRules.checkIfUserNameExists(createInstructorRequest.getUserName());
        Instructor instructor=modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
        InstructorResponse response=modelMapperService.forResponse().map(instructor, InstructorResponse.class);
        return new SuccessDataResult<InstructorResponse>(response);
    }

    @Override
    public DataResult<InstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
        InstructorResponse response=modelMapperService.forResponse().map(instructor, InstructorResponse.class);
        return new SuccessDataResult<InstructorResponse>(response);
    }

    @Override
    public Result delete(int id) {
        instructorRepository.deleteById(id);
        return new SuccessResult();
    }
}
