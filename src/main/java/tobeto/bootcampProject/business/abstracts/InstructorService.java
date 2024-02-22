package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.GetByIdInstructorResponse;

import java.util.List;

public interface InstructorService {
    List<GetAllInstructorResponse> getAll();
    GetByIdInstructorResponse getById(int id);
    void add(CreateInstructorRequest createInstructorRequest);
    void update(UpdateInstructorRequest updateInstructorRequest);
    void delete(int id);
}
