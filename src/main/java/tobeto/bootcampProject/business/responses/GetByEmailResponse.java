package tobeto.bootcampProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByEmailResponse {
    private int id;
    private  String userName;
    private  String email;

}
