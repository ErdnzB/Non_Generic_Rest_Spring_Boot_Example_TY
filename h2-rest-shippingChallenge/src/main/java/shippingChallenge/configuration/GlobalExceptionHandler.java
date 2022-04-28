package shippingChallenge.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ShippingChallengeApiException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ShippingChallengeApiException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getErrorCode().getMessage(),
                request.getDescription(false));
        return new ResponseEntity(exceptionResponse,ex.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Exception> handleException(Exception ex) {
        return ResponseEntity.status(EnumMessages.INTERNAL_SERVER_ERROR.getHttpStatus()).body(ex);
    }


}