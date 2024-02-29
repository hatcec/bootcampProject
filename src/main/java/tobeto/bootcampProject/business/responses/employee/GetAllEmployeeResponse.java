package tobeto.bootcampProject.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
    private int id;
    private String userName;
    private  String firstName;
    private  String lastName;
    private String position;
}
