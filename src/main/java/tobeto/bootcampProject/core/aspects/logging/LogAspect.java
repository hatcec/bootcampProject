package tobeto.bootcampProject.core.aspects.logging;


import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.LogParameter;
import tobeto.bootcampProject.core.crosscuttingconcerns.loggingn.LoggerServiceBase;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class LogAspect {
    private final LoggerServiceBase loggerServiceBase;
    private HttpServletRequest request;

    @Autowired
    public LogAspect(LoggerServiceBase loggerServiceBase,
                     HttpServletRequest httpServletRequest) {
        this.loggerServiceBase = loggerServiceBase;
        this.request = httpServletRequest;
    }

    @Pointcut("within(@org.springframework.stereotype.Repository *)"
            + " || within(@org.springframework.stereotype.Service *)"
            + " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {

    }

    @Around("springBeanPointcut() && @annotation(com.tobeto.rentacar.core.aspects.logging.Loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        String methodName = joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName();

        List<LogParameter> logparameters = new ArrayList<>();
        logparameters.add(new LogParameter(result));

        String userName = getUserName();

        loggerServiceBase.log(methodName, logparameters, userName);
        return result;

    }

    private String getUserName() {
        if (request.getUserPrincipal() != null) {
            return request.getUserPrincipal().getName();
        } else {
            return "?";
        }
    }
}
