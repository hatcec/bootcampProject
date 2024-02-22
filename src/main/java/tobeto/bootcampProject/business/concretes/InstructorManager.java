package tobeto.bootcampProject.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcampProject.business.abstracts.InstructorService;
import tobeto.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.GetByIdInstructorResponse;
import tobeto.bootcampProject.core.mappers.ModelMapperService;
import tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcampProject.entity.Instructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository instructorRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllInstructorResponse> getAll() {
        List<Instructor> instructors=instructorRepository.findAll();
        List<GetAllInstructorResponse> getAllInstructorResponses=instructors.stream()
                .map(instructor->modelMapperService.forResponse()
                        .map(instructor,GetAllInstructorResponse.class)).collect(Collectors.toList());

        return getAllInstructorResponses;
    }

    @Override
    public GetByIdInstructorResponse getById(int id) {
        Instructor instructor=instructorRepository.findById(id).orElseThrow();//eğer id gelmezse orElse olmazsa optinal yazarız
        GetByIdInstructorResponse response=modelMapperService.forResponse()
                .map(instructor,GetByIdInstructorResponse.class);
        return response;
    }

    @Override
    public void add(CreateInstructorRequest createInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(createInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
    }

    @Override
    public void update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor=modelMapperService.forRequest().map(updateInstructorRequest,Instructor.class);//mapped
        this.instructorRepository.save(instructor);
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }
}
