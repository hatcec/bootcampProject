package tobeto.bootcampProject.business.responses.bootcampstate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBootcampStatesResponse {
    private int id;
    private String state;
}