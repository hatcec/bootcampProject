package tobeto.bootcampProject.business.requests.application;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateApplicationRequest {
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
