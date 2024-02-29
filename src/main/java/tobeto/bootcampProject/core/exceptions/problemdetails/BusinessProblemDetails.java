package tobeto.bootcampProject.core.exceptions.problemdetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends  ProblemDetails{
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("http://tobeto.com/exceptions/business");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }
}
