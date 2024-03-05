package tobeto.bootcampProject.business.requests.applicant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest {
    @NotEmpty(message = "Username can not be empty!")
    @Size(min = 2, max = 25, message = "Username must be at least 2 characters!")
    private String userName;
    @NotEmpty(message = "Firstname can not be empty!")
    @Size(min = 2, max = 50, message = "Firstname must be at least 2 characters!")
    private  String firstName;
    @NotEmpty(message = "Lastname can not be empty!")
    @Size(min = 2, max = 50, message = "Lastname must be at least 2 characters!")
    private  String lastName;
    @NotEmpty(message = "Lastname can not be empty!")
    @Size( max = 250, message = "About field can not be more than 250 characters!")
    private String about;
}
