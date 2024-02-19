package tobeto.bootcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdApplicantResponse {
    private int id;
    private String about;
    private  String userName;
}
