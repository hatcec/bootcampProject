package tobeto.bootcampProject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    private String companyName;
    private String userName;
    private  String firstName;
    private  String lastName;
}
