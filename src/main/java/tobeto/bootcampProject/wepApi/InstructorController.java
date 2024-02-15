package tobeto.bootcampProject.wepApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcampProject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcampProject.entity.Instructor;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorRepository instructorRepository;
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @RequestMapping("/getall")
    public List<Instructor> findAll() {
        List<Instructor> instructors=instructorRepository.findAll();
        return instructors;
    }

    @RequestMapping("/save")
    public Instructor instructor() {
        Instructor instructor = new Instructor();
        instructor.setUserName("hatice");
        instructor.setEmail("hatice@gmail.com");
        instructor.setCompanyName("atesscompany");
        instructorRepository.save(instructor);
        return instructor;
    }

}
