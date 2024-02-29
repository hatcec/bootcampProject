package tobeto.bootcampProject.wepApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcampProject.business.abstracts.InstructorService;
import tobeto.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import tobeto.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import tobeto.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import tobeto.bootcampProject.business.responses.instructor.GetByIdInstructorResponse;
import tobeto.bootcampProject.core.results.Result;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/instructors")
public class InstructorController extends  BaseController {
    private InstructorService instructorService;

    @RequestMapping("/getall")
    public ResponseEntity<?> findAll(){
        return  handleDataResult(instructorService.getAll());
    }
    @GetMapping("/{id}")//variable al pathden okur
    public  ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(instructorService.getById(id));
    }
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public  ResponseEntity<?> add(@RequestBody() CreateInstructorRequest instructorRequest){
       return  handleDataResult(instructorService.add(instructorRequest));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody() UpdateInstructorRequest updateInstructorRequest){
        return handleDataResult(instructorService.update(updateInstructorRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(instructorService.delete(id));
    }

}
