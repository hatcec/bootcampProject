package tobeto.bootcampProject.business.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String position;
    private String userName;
    private  String firstName;
    private  String lastName;
}
