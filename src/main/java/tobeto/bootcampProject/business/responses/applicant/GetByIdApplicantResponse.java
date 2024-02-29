package tobeto.bootcampProject.business.responses.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdApplicantResponse {
    private int id;
    private String about;
    private String userName;
    private  String firstName;
    private  String lastName;
}
