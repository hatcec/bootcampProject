package tobeto.bootcampProject.core.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class InternalServerErrorProblemDetail extends  ProblemDetails{


    public InternalServerErrorProblemDetail() {
        setTitle("Internal Rule Violation");
        setType("http://tobeto.com.exceptions/business");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
