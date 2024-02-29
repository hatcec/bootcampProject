package tobeto.bootcampProject.core.exceptions.problemdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import tobeto.bootcampProject.core.exceptions.problemdetails.ProblemDetails;

import java.util.Map;
@AllArgsConstructor
@Data
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> errors;//hangi alanda ne hatası var(hashmap)

    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setType("http://tobeto.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
