package tobeto.bootcampProject.business.requests.blacklist;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.entity.Applicant;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListRequest {
    @NotEmpty(message = "Username can not be empty!")
    @Size(min = 2, max = 25, message = "Username must be at least 2 characters!")
    private String userName;
    @NotEmpty(message = "Firstname can not be empty!")
    @Size(min = 2, max = 50, message = "Firstname must be at least 2 characters!")
    private String firstName;
    @NotEmpty(message = "Lastname can not be empty!")
    @Size(min = 2, max = 50, message = "Lastname must be at least 2 characters!")
    private String lastName;
    @NotEmpty(message = "Lastname can not be empty!")
    @Size( max = 250, message = "Reason field can not be more than 250 characters!")
    private String reason;
    @Temporal(TemporalType.DATE)
    private Date date;
}
