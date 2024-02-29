package tobeto.bootcampProject.business.responses.applicationstate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationStatesResponse {
    private int id;
    private String state;
}