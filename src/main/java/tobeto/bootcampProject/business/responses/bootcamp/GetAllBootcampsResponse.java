package tobeto.bootcampProject.business.responses.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampsResponse {
    private int id;
    private String name;
    private int instructorId;
}