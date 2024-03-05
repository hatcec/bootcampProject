package tobeto.bootcampProject.business.requests.employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Positive
    private int id;
    @NotEmpty(message = "Username can not be empty!")
    @Size(min = 2, max = 25, message = "Username must be at least 2 characters!")
    private String userName;
    @NotEmpty(message = "Firstname can not be empty!")
    @Size(min = 2, max = 50, message = "Firstname must be at least 2 characters!")
    private  String firstName;
    @NotEmpty(message = "Lastname can not be empty!")
    @Size(min = 2, max = 50, message = "Lastname must be at least 2 characters!")
    private  String lastName;
    @NotEmpty(message = "Position can not be empty!")
    @Size( max = 25, message = "Position field can not be more than 25 characters!")
    private String position;
}
