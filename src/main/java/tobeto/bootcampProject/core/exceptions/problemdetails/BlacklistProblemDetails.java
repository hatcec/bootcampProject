package tobeto.bootcampProject.core.exceptions.problemdetails;

import org.springframework.http.HttpStatus;

public class BlacklistProblemDetails  extends ProblemDetails{
    public BlacklistProblemDetails() {
        setTitle("BlackList Rule Violation");
        setType("http://tobeto.com/exceptions/Blacklist");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
