package tobeto.bootcampProject.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByEmailResponse {
    private int id;
    private String userName;
    private  String firstName;
    private  String lastName;
    private String position;

}
