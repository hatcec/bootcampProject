package tobeto.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcampProject.entity.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
}
