package tobeto.bootcampProject.business.responses.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int getApplicantId;
}
