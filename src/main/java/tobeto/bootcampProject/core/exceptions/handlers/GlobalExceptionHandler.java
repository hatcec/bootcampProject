package tobeto.bootcampProject.core.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tobeto.bootcampProject.core.exceptions.problemdetails.BlacklistProblemDetails;
import tobeto.bootcampProject.core.exceptions.problemdetails.BusinessProblemDetails;
import tobeto.bootcampProject.core.exceptions.problemdetails.InternalServerErrorProblemDetail;
import tobeto.bootcampProject.core.exceptions.problemdetails.ValidationProblemDetails;
import tobeto.bootcampProject.core.exceptions.types.BlacklistException;
import tobeto.bootcampProject.core.exceptions.types.BusinessException;
import tobeto.bootcampProject.core.exceptions.types.DataIntegrityViolationException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails businessException(BusinessException businessException){
        BusinessProblemDetails problemDetails=new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails validationException(MethodArgumentNotValidException validException){
        Map<String, String > validationErrors=new HashMap<>();
        validException.getBindingResult().getFieldErrors().stream()
                .map(error->validationErrors.put(error.getField(),error.getDefaultMessage()))
                .collect(Collectors.toList());
        ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerErrorProblemDetail handleDataIntegrityViolationException(
            DataIntegrityViolationException exception) {
        InternalServerErrorProblemDetail detail = new InternalServerErrorProblemDetail();
        detail.setDetail(exception.getMessage());
        return detail;
    }
    @ExceptionHandler(BlacklistException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BlacklistProblemDetails blacklistException(BlacklistException blacklistException){
        BlacklistProblemDetails problemDetails=new BlacklistProblemDetails();
        problemDetails.setDetail(blacklistException.getMessage());
        return problemDetails;
    }

}
