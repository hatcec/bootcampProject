package tobeto.bootcampProject.business.requests.blacklist;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListRequest {
    @Positive
    private int id;
    @NotNull(message = "Applicant ID must not be null!")
    private int applicantId;
    @Size( max = 250, message = "Reason field can not be more than 250 characters!")
    private String reason;
    @Temporal(TemporalType.DATE)
    private Date date;
}
