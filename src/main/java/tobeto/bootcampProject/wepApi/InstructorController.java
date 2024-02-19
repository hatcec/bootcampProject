package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.EmployeeService;
import tobeto.bootcampProject.business.abstracts.InstructorService;
import tobeto.bootcampProject.business.requests.CreateEmployeeRequest;
import tobeto.bootcampProject.business.requests.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.UpdateEmployeeRequest;
import tobeto.bootcampProject.business.requests.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.GetAllEmployeeResponse;
import tobeto.bootcampProject.business.responses.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.GetByIdEmployeeResponse;
import tobeto.bootcampProject.business.responses.GetByIdInstructorResponse;
import tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcampProject.entity.Instructor;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorService instructorService;


    @RequestMapping("/getall")
    public List<GetAllInstructorResponse> findAll(){
        return  instructorService.getAll();
    }
    @GetMapping("/{id}")//variable al pathden okur
    public GetByIdInstructorResponse getById(@PathVariable int id) {
        return instructorService.getById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  void add(@RequestBody() CreateInstructorRequest instructorRequest){
        instructorService.add(instructorRequest);
    }
    @PutMapping
    public void update(@RequestBody() UpdateInstructorRequest updateInstructorRequest){
        instructorService.update(updateInstructorRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        instructorService.delete(id);
    }

}
