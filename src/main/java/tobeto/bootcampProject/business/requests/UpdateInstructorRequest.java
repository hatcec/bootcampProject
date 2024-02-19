package tobeto.bootcampProject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
    private int id;
    private String userName;
    private  String firstName;
    private  String lastName;
    private String companyName;
}
