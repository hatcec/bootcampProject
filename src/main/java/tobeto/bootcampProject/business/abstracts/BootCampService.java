package tobeto.bootcampProject.business.abstracts;

import tobeto.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import tobeto.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import tobeto.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import tobeto.bootcampProject.business.responses.bootcamp.GetByIdBootcampResponse;

import java.util.List;

public interface BootCampService {
    List<GetAllBootcampsResponse> getAll();
    GetByIdBootcampResponse getById(int id);
    void add(CreateBootcampRequest bootcampRequest);
    void update(UpdateBootcampRequest bootcampRequest);
    void delete(int id);
}
