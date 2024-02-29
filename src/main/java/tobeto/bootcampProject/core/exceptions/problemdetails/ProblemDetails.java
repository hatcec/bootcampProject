package tobeto.bootcampProject.core.exceptions.problemdetails;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    private  String title;
    private  String detail;
    private  String status;
    private  String type;
}
