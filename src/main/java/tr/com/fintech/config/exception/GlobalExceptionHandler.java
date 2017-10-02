package tr.com.fintech.config.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ErrorDTO handleUnauthorizedException(HttpClientErrorException ex, WebRequest webRequest) {
        return ex.getStatusCode() == HttpStatus.UNAUTHORIZED
                ? new ErrorDTO("Token expired", ex.getMessage())
                : new ErrorDTO(ex.getMessage(), ex.getMessage());
    }
}
