package tobeto.bootcampProject.business.responses.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampResponse {
    private int id;
    private String name;
    private int instructorId;
}
