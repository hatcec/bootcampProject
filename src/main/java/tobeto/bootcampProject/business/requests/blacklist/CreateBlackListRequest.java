package tobeto.bootcampProject.business.requests.blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.entity.Applicant;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListRequest {
    private String reason;
    private Date date;
    private Applicant applicant;
}
