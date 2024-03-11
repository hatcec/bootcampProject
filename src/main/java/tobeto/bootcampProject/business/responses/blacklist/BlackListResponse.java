package tobeto.bootcampProject.business.responses.blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlackListResponse {
    private int id;
    private String userName;
    private  String firstName;
    private  String lastName;
    private String reason;
    private Date date;
}
