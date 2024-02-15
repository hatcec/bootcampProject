package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
