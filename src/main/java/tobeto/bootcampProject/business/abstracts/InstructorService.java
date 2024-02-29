package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.employee.EmployeeResponse;
import tobeto.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.GetByIdInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.InstructorResponse;
import tobeto.bootcampProject.core.results.DataResult;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

public interface InstructorService {
    DataResult<List<GetAllInstructorResponse>> getAll();
    DataResult<GetByIdInstructorResponse> getById(int id);
    DataResult<InstructorResponse> add(CreateInstructorRequest createInstructorRequest);
    DataResult<InstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
    Result delete(int id);
}
