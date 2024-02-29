package tobeto.bootcampProject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice//api a enteegre edicem
public class BootcampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampProjectApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return  new ModelMapper();
	}
   /* @ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		ErrorDataResult<Object> errorDataResult=new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS.EXCEPTION");
		return errorDataResult;
	}*/
	/*@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException validException){//businessexception alırsa çalışacak
		ValidationProblemDetails problemDetails=new ValidationProblemDetails();
		problemDetails.setMessage("VALIDATION.EXCEPTION");
		problemDetails.setValidationErrors(new HashMap<String ,String>());
		for(FieldError fieldError:validException.getBindingResult().getFieldErrors()){
			problemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return  problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){//businessexception alırsa çalışacak
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return  problemDetails;
	}*/
}
