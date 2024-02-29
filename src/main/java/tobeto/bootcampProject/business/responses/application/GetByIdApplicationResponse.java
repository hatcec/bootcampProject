package tobeto.bootcampProject.business.responses.application;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private int getApplicantId;
}