package tobeto.bootcampProject.business.responses.blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.entity.Applicant;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdBlackListResponse {
    private  int id;
    private String reason;
    private Date date;
    private int applicant_id;
}
