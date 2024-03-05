package tobeto.bootcampProject.business.requests.instructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
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
    @NotEmpty(message = "CompanyName can not be empty!")
    @Size( max = 35, message = "CompanyName field can not be more than 35 characters!")
    private String companyName;
}
