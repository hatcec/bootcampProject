package tobeto.bootcampProject.business.responses.blacklist;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.entity.Applicant;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBlackListResponse {
    private  int id;
    private String reason;
    private Date date;
    private int applicant_id;//firstnme lastname email gelsin!
}
