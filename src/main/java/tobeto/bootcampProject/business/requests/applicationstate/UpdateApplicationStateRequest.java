package tobeto.bootcampProject.business.requests.applicationstate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationStateRequest {
    private int id;
    private String name;
}