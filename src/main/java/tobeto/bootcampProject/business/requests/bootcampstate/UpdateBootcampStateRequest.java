package tobeto.bootcampProject.business.requests.bootcampstate;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampStateRequest {
    @Positive
    private int id;
    private String name;
}
