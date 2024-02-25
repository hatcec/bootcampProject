package tobeto.bootcampProject.business.requests.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
